#!/usr/bin/python3
from qzone import *
import base64
import json
uid = open('account.txt').read()
file_context = open('cookies.txt').read()
qz = Qzone(**cookie_str_to_dict(file_context))
dat = qz.emotion_list(int(uid),1)[0]
dat.load()
obj = json.dumps(obj=dat, default=lambda x : x.__dict__, sort_keys=False, indent=2)
print(base64.b64encode(obj.encode()).decode())
