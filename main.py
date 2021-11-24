#!/usr/bin/python3
from qzone import *
import base64
import json
uid = open('account.txt').read()
file_context = open('cookies.txt').read()
qz = Qzone(**cookie_str_to_dict(file_context))
dat = qz.emotion_list(int(uid),1)[0]
dat.load()
print(base64.b64encode(json.dumps(dat.getRaw()).encode()).decode())