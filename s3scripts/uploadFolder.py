import boto3
import botocore
import os
import sys

BUCKET_NAME = 'lemur-omar-bucket' # replace with your bucket name
FOLDER_NAME = 'testUploadDir'
KEY = FOLDER_NAME + '/'

# s3 = boto3.client('s3')

"""
params:
- path: local path of file or directory to be uploaded.
"""
def upload_files(path):
    s3  = boto3.resource('s3')
    bucket = s3.Bucket(BUCKET_NAME)

    # use os.walk to traverse directory tree
    for subdir, dirs, files in os.walk(path):
        for file in files:
            full_path = os.path.join(subdir, file)
            with open(full_path, 'rb') as data:
                print(full_path)
                bucket.put_object(Key=full_path[len(path)+1:], Body=data)

if __name__ == "__main__":
    try:
        upload_files(FOLDER_NAME)
        print("The contents of the '%s' object has successfully uploaded" % FOLDER_NAME)

    except botocore.exceptions.ClientError as e:
       if e.response['Error']['Code'] == "404":
           print("The object does not exist.")
       else:
           raise
