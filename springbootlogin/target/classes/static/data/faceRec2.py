# -*- coding: utf-8 -*-
# @Author: Junone
# @Date:   2018-05-26 15:12:43
# @Last Modified by:   Junone
# @Last Modified time: 2018-05-28 19:15:17
import face_recognition
import os


def getAllImages(folder):
    assert os.path.exists(folder)
    assert os.path.isdir(folder)
    imageList = os.listdir(folder)
#    imageList = 
    return imageList
def isImage(fn):
	return os.path.splitext(fn)[-1] in ('.jpg', '.JPG', '.png', '.PNG','.jpeg')

imageList=getAllImages(r"img//")
delList=[]
for i in range(len(imageList)):
	if isImage(imageList[i])==False:
		delList.append(i)

for item in delList:
	del imageList[item]
print(delList)
print (imageList)

def faceReAll(imageUnknow,imageList):
	finallResult=False
	unknown_image=face_recognition.load_image_file(imageUnknow)
	unknown_encoding =face_recognition.face_encodings(unknown_image)[0]
	id=0
	for item in imageList:
		known_image =face_recognition.load_image_file("img/"+item)
		biden_encoding =face_recognition.face_encodings(known_image)[0]
		results=face_recognition.compare_faces([biden_encoding],unknown_encoding,tolerance=0.45)
		print(results)
		if results[0]==True:
			finallResult=True
			id = item
			file=open('result.txt','a')
			file.write('"'+"suspect"+'": '+str(1)+','+'\n')
			file.write('"'+"criminal"+'": ')
			file.write('"'+id.split(' ',1)[0])
			file.write(' ')
			file.write(id.split(' ',1)[1].split('.',1)[0]+'"'+'\n'+'}')
			file.close()
			break
	if finallResult==False:
		file=open('result.txt','a')
		file.write('"'+"suspect"+'": '+str(0)+','+'\n')
		file.write('"'+"criminal"+'": ')
		file.write('"'+'"')
		file.write('\n'+'}')
	return finallResult

print(faceReAll("picture1.jpg",imageList))