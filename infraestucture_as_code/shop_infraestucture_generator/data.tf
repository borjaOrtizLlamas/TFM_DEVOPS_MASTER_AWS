resource "aws_dynamodb_table" "basic-dynamodb-table" {
  name           = "dababase-proyect"
  billing_mode   = "PROVISIONED"
  read_capacity  = 1
  write_capacity = 1
  hash_key       = "name"

  attribute {
    name = "name"
    type = "S"
  }


  tags = {
    Name        = "dababase-proyect"
    Environment = "${var.SUFIX}"
  }
}