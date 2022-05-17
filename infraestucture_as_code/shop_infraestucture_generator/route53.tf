resource "aws_route53_zone" "dns-private" {
  name = "tfm.com"
  comment = "route53 zone for ${var.SUFIX}"
  vpc {
    vpc_id = "${aws_vpc.unir_shop_vpc_dev.id}"
  }
}
