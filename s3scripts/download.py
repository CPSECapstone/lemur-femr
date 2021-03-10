import boto3
import botocore
import os
from datetime import datetime

BUCKET_NAME = 'lemur-omar-bucket' # replace with your bucket name
LOCAL_DEST = '/Users/omarshorab/IdeaProjects/lemur-femr/s3scripts/' # local destination for download

s3 = boto3.client('s3')

"""
params:
- prefix: pattern to match in s3
- local: local path to folder in which to place files
- bucket: s3 bucket with target contents
- client: s3 client object
"""
def download_files(prefix, local, bucket, client):
    keys = []
    dirs = []
    next_token = ''
    base_kwargs = {
        'Bucket':bucket,
        'Prefix':prefix,
    }
    # compiles objects into lists of dirs and keys(only files have keys)
    while next_token is not None:
        kwargs = base_kwargs.copy()
        if next_token != '':
            kwargs.update({'ContinuationToken': next_token})
        results = client.list_objects_v2(**kwargs)
        contents = results.get('Contents')
        for i in contents:
            k = i.get('Key')
            if k[-1] != '/': # i.e. object is a file
                keys.append(k)
            else: # object is a directory by looking at its path
                dirs.append(k)
        next_token = results.get('NextContinuationToken')

    # adds directory to given destination path (local),
    # and creates a directory for it if it doesn't exist.
    for d in dirs:
        dest_pathname = os.path.join(local, d)
        if not os.path.exists(os.path.dirname(dest_pathname)):
            os.makedirs(os.path.dirname(dest_pathname))

    # download files into appropriate directories
    for k in keys:
        dest_pathname = os.path.join(local, k)
        if not os.path.exists(os.path.dirname(dest_pathname)):
            os.makedirs(os.path.dirname(dest_pathname))
        client.download_file(bucket, k, dest_pathname)


if __name__ == "__main__":
    try:
        # can make this prefix more meaningful depending on s3 bucket organization
        PREFIX = ''
        download_files(PREFIX, LOCAL_DEST, BUCKET_NAME, s3)
        print("The contents of '%s' have been successfully downloaded into '%s'" % (BUCKET_NAME, LOCAL_DEST))

    except botocore.exceptions.ClientError as e:
       if e.response['Error']['Code'] == "404":
           print("The object does not exist.")
       else:
           raise