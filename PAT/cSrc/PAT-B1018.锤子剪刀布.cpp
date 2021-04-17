#include <stdio.h>
int change(char c) //创建一个函数，将字符转换成数字
{
    if (c == 'B') return 0;//出布的话，就返回数字0
    if (c == 'C') return 1;//出石头的话，就返回数字1
    if (c == 'J') return 2;//出剪刀的话，就返回数字2
}

int main()
{
    char map[3] = {'B', 'C', 'J'};//创建一个字符数组存储石头,剪刀,布
    int n;
    scanf("%d", &n);
    int times_A[3] = {0}, times_B[3] = {0};
    // 分别记录甲乙的胜、负、平的次数
    int hand_A[3] = {0}, hand_B[3] = {0};
    // 按照BCJ顺序分别记录甲乙三种手势的获胜次数
    char c1, c2;// 甲乙的手势
    int k1, k2;
    for (int i = 0; i < n; i++)
    {
        getchar();
        scanf("%c %c", &c1, &c2);
        k1 = change(c1);
        k2 = change(c2);

        if ((k1 + 1) % 3 == k2) 
        {// 如果甲胜
            times_A[0]++;// 甲胜次数+1
            times_B[2]++;// 乙负次数+1
            hand_A[k1]++;// 记录甲获胜的手势
        } else if ((k1 == k2)) 
        {// 如果平局
            times_A[1]++;// 甲平局次数+1
            times_B[1]++;// 乙平局次数+1
        } else 
        {// 如果乙胜
            times_A[2]++;// 甲负次数+1
            times_B[0]++;// 乙胜次数+1
            hand_B[k2]++;// 记录乙获胜的手势
        }
    }
     // 分别输出甲、乙 胜、平、负的次数
    printf("%d %d %d\n", times_A[0], times_A[1], times_A[2]);
    printf("%d %d %d\n", times_B[0], times_B[1], times_B[2]);

    int id1 = 0, id2 = 0;
    // 记录甲、乙获胜次数最多的手势
    for (int i = 0; i < 3; i++) 
    {
        if (hand_A[i] > hand_A[id1]) 
        {
            id1 = i;
        }
        if (hand_B[i] > hand_B[id2]) 
        {
            id2 = i;
        }
    }
    printf("%c %c\n", map[id1], map[id2]);
    return 0;
}
