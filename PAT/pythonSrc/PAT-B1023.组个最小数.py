#输入测试数据中 0-9 每个数字的个数
data = list(map(int,input().split()))

#先输出最小的非0数字
for i in range(1,10):
	if data[i] > 0:	#非0判断
		print(i,end='')	#防止一个数字一换行
		data[i] -= 1
		break

#剩余数字由小到大输出
for i in range(10):
	for j in range(data[i]):
		print(i,end='')