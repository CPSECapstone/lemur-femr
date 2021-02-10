import boto3
import botocore
from datetime import datetime

BUCKET_NAME = 'lemur-bucket' # replace with your bucket name

s3 = boto3.client('s3')
objs = s3.list_objects_v2(Bucket=BUCKET_NAME)['Contents']
get_last_modified = lambda obj: int(obj['LastModified'].timestamp())
latest = [obj['Key'] for obj in sorted(objs, key=get_last_modified)][0]

try:
    s3.download_file(BUCKET_NAME, latest, latest)
    print("The file '%s' was sucessfully downloaded!" % latest)
    print("It has been saved to the current working directory.")
except botocore.exceptions.ClientError as e:
    if e.response['Error']['Code'] == "404":
        print("The object does not exist.")
    else:
        raise



