import boto3
import botocore

BUCKET_NAME = 'lemur-bucket' # replace with your bucket name
KEY = 'uploadTest.txt' # replace with your object na
UPLOAD_NAME = "success.txt" #replace with desired output name

s3 = boto3.resource('s3')

try:
    s3.Bucket(BUCKET_NAME).upload_file(KEY, UPLOAD_NAME)
    print("The file 'hello.txt' was sucessfully downloaded and saved as 'success.txt'!")
    print("It has been saved to the current working directory.")
except botocore.exceptions.ClientError as e:
    if e.response['Error']['Code'] == "404":
        print("The object does not exist.")
    else:
        raise
