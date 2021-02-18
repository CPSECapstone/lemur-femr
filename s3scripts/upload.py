import boto3
import botocore

BUCKET_NAME = 'lemur-omar-bucket' # replace with your bucket name
KEY = 'test.txt' # replace with your object na
UPLOAD_NAME = "test.txt" #replace with desired output name

s3 = boto3.resource('s3')

try:
    s3.Bucket(BUCKET_NAME).upload_file(KEY, UPLOAD_NAME)
    print("The file '%s' was sucessfully uploaded and saved as '%s'!" % (KEY, UPLOAD_NAME))
except botocore.exceptions.ClientError as e:
    if e.response['Error']['Code'] == "404":
        print("The object does not exist.")
    else:
        raise
