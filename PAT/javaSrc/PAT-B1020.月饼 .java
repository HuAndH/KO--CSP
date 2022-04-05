import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Mooncake002 {
    public static void main(String[] args){

//        3 20       //月饼种类数 int number   市场需求量 double marketDemand
//        18 15 10   //n种月饼的库存量(t) double mooncake[]
//        75 72 45   //n种月饼全部售空各种月饼所得收益(亿元) double money[]
//
//        要求输出最高收益： double highestYield;

        //信息描述

        System.out.println("3 20       //月饼种类数 int number   市场需求量 double marketDemand");
        System.out.println("18 15 10   //n种月饼的库存量(wt) double[] mooncake");
        System.out.println("75 72 45   //n种月饼全部售空各种月饼所得收益(亿元) double[] money");
        System.out.println("请按上述所给示例输入信息：");
        int number;  //月饼种类数
        double marketDemand;  //市场需求量
        double highestYield;  //最高收益

        //数据采集

        Scanner scanner = new Scanner(System.in);

        //月饼种类数
//        不超过 1000 的正整数表示月饼的种类数
        while(true){
            number = scanner.nextInt();
            if(number < 0 | number >=1000){
                System.out.println("月饼种类数输入错误！");
                System.out.print("请输入[1,10000]之间的整数: ");
            }
            else break;
        }

        double[] mooncake=new double[number];  //n种月饼的库存量(wt)
        double[] money= new double[number];  //n种月饼全部售空各种月饼所得收益(亿元)

        //市场需求量
//        不超过 500（以万吨为单位）的正整数 D 表示市场最大需求量。
        while(true){
            marketDemand = scanner.nextDouble();
            if(marketDemand  > 500  | marketDemand < 1)
            {
                System.out.println("市场需求量输入错误！");
                System.out.print("请输入[0,500]之间的数: ");
            }
            else break;
        }

        //n种月饼的库存量(wt)
        for(int i=1 ; i <= number ; i++)
        {
            mooncake[i-1] = scanner.nextDouble();
            if(mooncake[i-1] < 0)
            {
                System.out.println(number+"种月饼的库存量输入错误！");
                System.out.println("请重新输入第"+i+"个数据：");
                i--;
            }
        }

        //n种月饼全部售空各种月饼所得收益(亿元)
        for(int i=1 ; i <= number ; i++){
            money[i-1] = scanner.nextDouble();
        }

        //运行 结果

        Method001 method001 = new Method001();
        highestYield=method001.zuiZuanQian(marketDemand,mooncake,money);
        System.out.println("最高收益为："+highestYield);
    }
}


class Method001{
    public double zuiZuanQian(double marketDemand,double[] mooncake,double[] money ){
        //新建 double[] unitPrice 单价(亿元/t)
        //计算各种月饼的单价
        //map 排序
        //减法。okk

        //新建 double[] unitPrice 单价(亿元/t)
        double best=0;    //最高收益
        double[] unitPrice = new double[mooncake.length];
        double[] mcake = new double[mooncake.length];
        double[] moy = new double[mooncake.length];
        for(int i = 1 ; i <= mooncake.length ; i++)
            mcake[i-1] = mooncake [i-1];
        for(int i = 1 ; i <= mooncake.length ; i++)
            moy[i-1] = money[i-1];

        //计算各种月饼的单价
        for(int i=1 ; i <= mooncake.length ; i++){
            unitPrice[i-1] = moy[i-1] / mcake[i-1];
        }

        //map 排序
        Arrays.sort(unitPrice);   //自带的排序  ↑

        //减法。okk
        for(int i = mooncake.length ; i >= 0 ; i--)
        {
            if(marketDemand >= 0 )
            {
                if(marketDemand >= mooncake[i-1])
                    best += money[i-1];
                else{
                    best += (mooncake[i-1]-marketDemand) * unitPrice[i-1];
                    return best;
                }
                marketDemand = marketDemand - mooncake[i-1];
            }
        }

        return best;
    }
}