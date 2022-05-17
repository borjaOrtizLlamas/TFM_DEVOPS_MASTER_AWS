##########
## api_rest
##########

resource "aws_security_group" "api_rest_group" {
  name        = "api rest group"
  description = "Api rest security"
  vpc_id      = "${aws_vpc.unir_shop_vpc_dev.id}"
  tags = {
    Name = "api rest group"
  }
}
resource "aws_security_group_rule" "eggress_group" {
  type              = "egress"
  from_port         = 0
  to_port           = 49151
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = "${aws_security_group.api_rest_group.id}"
}

resource "aws_security_group_rule" "ingress_group" {
  type              = "ingress"
  from_port         = 0
  to_port           = 49151
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = "${aws_security_group.api_rest_group.id}"
}


###################
# Setup for IAM role needed to setup an EKS cluster
resource "aws_iam_role" "eks_cluster_role" {
  name = "eks-cluster-${var.SUFIX}"

  assume_role_policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "ec2.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
POLICY
}


resource "aws_iam_role" "eks_nodes_role" {
  name = "eks-node-${var.SUFIX}"

  assume_role_policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "ec2.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
POLICY
}

resource "aws_iam_role_policy_attachment" "AmazonEKSClusterPolicy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
  role       = "${aws_iam_role.eks_cluster_role.name}"
}