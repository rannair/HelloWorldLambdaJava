# HelloWorldLambdaJava

Creates and deploys a "Hello World" AWS Lambda function, implemented in Java.

## Prerequisites

* Created: An AWS account, and an S3 bucket for storing temporary deployment artifacts 
* Installed: AWS CLI, Maven, SAM CLI
* Configured: AWS credentials in your terminal

## Usage

To build:

```
 mvn package
```

To deploy:

```
sam deploy --s3-bucket <bucket_name> --stack-name HelloWorldLambdaJava --capabilities CAPABILITY_IAM
```
The above will create a new function in Lambda, so you can test via the Lambda web console,
or via the CLI using `aws lambda invoke`.

To test:
```
aws lambda invoke --invocation-type RequestResponse  --function-name HelloWorldJava outputfile.txt

```
```
aws lambda invoke --invocation-type RequestResponse  --function-name TimeoutLambda outputfile.txt
```
```
aws lambda invoke --invocation-type RequestResponse  --function-name HelloWorldJava  --cli-binary-format raw-in-base64-out  --payload { "world": "$input.params('s')" } outputfile.txt
```
```
aws lambda invoke  --invocation-type RequestResponse --function-name HelloWorldJava --cli-binary-format raw-in-base64-out --payload '{ "title": "Lambda-development" }' outputfile.txt
```
Tear down stack using:
```
aws cloudformation delete-stack --stack-name HelloWorldLambdaJava

```