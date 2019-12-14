# -*- coding: utf-8 -*-
# @Author: Junone
# @Date:   2018-05-26 14:57:20
# @Last Modified by:   Junone
# @Last Modified time: 2018-05-28 14:36:29
import face_recognition



known_image =face_recognition.load_image_file("picture1.jpg")

unknown_image =face_recognition.load_image_file("picture2.jpg")

biden_encoding =face_recognition.face_encodings(known_image)[0]
unknown_encoding =face_recognition.face_encodings(unknown_image)[0]

results=face_recognition.compare_faces([biden_encoding],unknown_encoding,tolerance=0.45)

res=0
if results[0]==True:
	res=1

file=open('result.txt','w')
file.write('{'+'\n')
file.write('"'+"match"+'": '+str(res)+','+'\n')
file.close()
