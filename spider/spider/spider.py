import requests
from bs4 import BeautifulSoup
import os

url = "https://tiyu.baidu.com/match/%E4%B8%AD%E8%B6%85/date_time/2024-03-10/tab/%E8%B5%9B%E7%A8%8B/from/baidu_aladdin"
# 发送HTTP GET请求
response = requests.get(url)

# 检查请求是否成功
if response.status_code == 200:
    # 使用BeautifulSoup解析HTML内容
    soup = BeautifulSoup(response.text, 'html.parser')

    # 根据网页结构定位数据
    # 这里是一个示例，你需要根据实际网页结构来提取所需数据
    # 例如，如果数据在一个表格中，你可能需要找到<table>标签
    # 如果数据在列表中，你可能需要找到<ul>或<ol>标签
    # 以下代码是一个示例，你需要根据实际情况修改
    data = soup.find_all('div', class_='c-pull-refresh-content')  # 替换成实际的类名或其他定位方法
    lines =[item.strip() for item in  data[0].text.split("\n") if item.strip()] #列表推导式

    for i in range(0,len(lines),4):
        chunk=lines[i:i+4]
        print("------------------------")
        for item in chunk:
            print(item.strip())
else:
    print('Failed to retrieve the webpage. Status code:', response.status_code)
