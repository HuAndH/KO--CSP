#include <iostream>
using namespace std;
int main()
{
    string s; // 输入需要判断的实数 A
    cin >> s;
    int i = 0; // 字符串的下标
    while (s[i] != 'E')
        i++;
    string t = s.substr(1, i - 1); // 以 E 为分界线，截取
    int n = stoi(s.substr(i + 1)); // 将数字字符串装换成 int 输出
    if (s[0] == '-')               // 处理含有 “-” 情况
        cout << "-";
    if (n < 0) // 处理小数的情况
    {
        cout << "0.";
        // 使用 abs() 函数取绝对值，然后遍历输出 0
        for (int j = 0; j < abs(n) - 1; j++)
            cout << '0';
        // 输出数字部分
        for (int j = 0; j < t.length(); j++)
            if (t[j] != '.') // 过滤小数点
                cout << t[j];
    }
    else
    {
        cout << t[0];
        int cnt, j;
        // 遍历输出
        for (j = 2, cnt = 0; j < t.length() && cnt < n; j++, cnt++)
            cout << t[j];
        if (j == t.length())
        {
            // 处理剩余的 0
            for (int k = 0; k < n - cnt; k++)
                cout << '0';
        }
        else
        {
            // 处理小数点后的元素
            cout << '.';
            for (int k = j; k < t.length(); k++)
                cout << t[k];
        }
    }
    return 0;
}
