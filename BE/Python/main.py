import requests
import pymongo

host = 'localhost'
port = 27017
client = pymongo.MongoClient(host=host,port=port)
db = client['MY_GS'].Barcode
lst = []
API_KEY ='119e010f0d674ed79656'
for i in range(1,100000000,1000):
    print(i)
    resData = requests.get("http://openapi.foodsafetykorea.go.kr/api/{}/C005/json/{}/{}/".format(API_KEY,i,i+999)).json()
    loc = resData['C005']['row']
    for j in loc:
        db.insert_one(j)


# dr = webdriver.Chrome()
# dr.get('https://www.bhc.co.kr/location/search.asp')
# act = ActionChains(dr)
# lst = []
#
# print(dr.find_element(By.CLASS_NAME, 'pr0'))
# dr.find_element(By.CLASS_NAME, 'pr0').click()
# time.sleep(5)
# for i in range(15):
#     next = dr.find_element(By.CLASS_NAME, 'paging').find_elements(By.TAG_NAME, 'a')
#     start=2
#     end = 13
#     for j in range(start,end):
#         next[j].click()
#         print(next[j].text)
#         time.sleep(5)
#         elem = dr.find_element(By.CLASS_NAME, 'register01').find_element(By.TAG_NAME, 'tbody').find_elements(
#             By.TAG_NAME, 'tr')
#         for k in range(len(elem)):
#             temp = elem[k].text
#             temp_lst = temp.split('\n')
#             temp_lst[1]= temp_lst[1][5:]
#             temp_lst[2]=temp_lst[2][7:]
#             x=0
#             y=0
#             print(temp_lst)
#             resData = requests.get(
#                 "http://api.vworld.kr/req/search?key={}&&query={}&&request=search&&type=ADDRESS&&category=ROAD".format(
#                     API_KEY, temp_lst[1])).json()
#             if 'result' in resData['response']:
#                 loc = resData['response']['result']['items'][0]['point']
#                 x = loc['x']
#                 y= loc['y']
#             db.insert_one({'name':temp_lst[0],'address':temp_lst[1],'phone':temp_lst[2],'x':x,'y':y})
#         next = dr.find_element(By.CLASS_NAME, 'paging').find_elements(By.TAG_NAME, 'a')
#     dr.find_elements(By.CLASS_NAME, 'pr0')[1].click()
#
# print(lst)