resource "aws_ecs_cluster" "api_rest_cluster" {
  name = "api_rest_cluster-${var.SUFIX}"
}
#dosent have any use ->
resource "aws_ecs_task_definition" "APIRestSmallCompany" {
    family = "APIRestSmallCompany-${var.SUFIX}"
    container_definitions = file("containers.json") #funciona
    volume {
        name      = "logs"
    }
    requires_compatibilities = ["FARGATE"]
    memory = 1024
    cpu = 208
    network_mode= "awsvpc"
    execution_role_arn = "${aws_iam_role.eks_cluster_role.arn}"
}


resource "aws_ecs_service" "service_for_api" {
  name            = "serviceApiRest-${var.SUFIX}"
  cluster         = "${aws_ecs_cluster.api_rest_cluster.id}"
  #task_definition = "${aws_ecs_task_definition.APIRestSmallCompany.arn}"
  launch_type = "FARGATE"
  
  network_configuration {
    subnets = ["${aws_subnet.unir_subnet_cluster_1.id}","${aws_subnet.unir_subnet_cluster_2.id}"]
    security_groups = ["${aws_security_group.api_rest_group.id}"]
    assign_public_ip = true
  }
  depends_on = ["aws_lb_target_group.targetForService"]
  load_balancer {
    target_group_arn = "${aws_lb_target_group.targetForService.arn}"
    container_name   = "smallComerceApiRest"
    container_port   = 8080
  }
  
  lifecycle {
    ignore_changes = [desired_count]
  }
}

# Create a new ALB Target Group attachment
resource "aws_autoscaling_attachment" "asg_attachment_bar" {
  autoscaling_group_name = "${aws_autoscaling_group.api.id}"
  alb_target_group_arn   = "${aws_lb_target_group.targetForService.arn}"
}




resource "aws_autoscaling_group" "api" {
  name                      = "autoescaling-group"
  max_size                  = 5
  min_size                  = 1
  health_check_grace_period = 300
  health_check_type         = "ELB"
  desired_capacity          = 1
  force_delete              = true
  vpc_zone_identifier       = ["${aws_subnet.unir_subnet_cluster_1.id}","${aws_subnet.unir_subnet_cluster_2.id}"]
  #launch_template           = "${aws_launch_template.template.name}"
  launch_template {
    id      = aws_launch_template.template.name
    version = "$Latest"
  }
}

resource "aws_launch_template" "template" {
 ###template 
}


##################
#     X-Ray      #
##################

