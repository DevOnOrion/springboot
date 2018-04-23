package com.atguigu.springboot;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author tangjun
 * @Description
 * @date 2018/4/23/02311:35
 */
public class ListTest {
    //浅谈Arrays.asList()的使用
    //该方法是将数组转换成list
    //该方法不适用于基本数据类型(byte,short,int,long,float,double,boolean)
    //该方法将数组与列表连接起来，当更新其中之一时，另一个自动更新
    //不支持add和remove方法
    @Test
    public void testList(){
        String[] s={"aa","bb","cc"};
        List<String> strList= Arrays.asList(s);
        for(String str:strList){
            System.out.println(str);
        }
        System.out.println("--------------------");
        //基本数据类型结果打印为一个元素
        int[] i={11,22,33};
        List intList=Arrays.asList(i);
        for (java.lang.Object o:intList){
            System.out.println(o.toString());
        }
        System.out.println("---------------");
        Integer[] ob={11,22,33};
        List<Integer> obList=Arrays.asList(ob);
        for (int a:obList){
            System.out.println(a);
        }
        System.out.println("-----------------");
    }

    @Test
    public void testCSDN(){
        /*段落1 基本数据类型使用asList的问题*/

        /*说明：虽然在jdk1.6中能够将基本类型的数组转换成List，但还是有缺陷*/
        System.out.println("段落一开始分割线------");
        int[] a_int={1,2,3,4};
        /*预期输出应该是1,2,3,4*/
        List a_int_List=Arrays.asList(a_int);
        foreach(a_int_List);
        /*为此我们需要这样遍历其中元素*/
        foreachForBase(a_int_List);

        /*段落2 对象类型的数组使用asList, 是我们预期的 */
        System.out.println("段落2开始分割线-------");
        Integer[] a_Integer=new Integer[]{1,2,3,4};
        List a_Integer_List=Arrays.asList(a_Integer);
        foreach(a_Integer_List);

        /*段落3 当更新数组或者asList之后的List，另一个将自动获得更新*/
        System.out.println("段落3开始分割线-------");
        a_Integer_List.set(0,0);
        foreach(a_Integer_List);
        foreach(a_Integer);

        a_Integer[0]=5;
        foreach(a_Integer_List);
        foreach(a_Integer);

        /*段落4 对基本类型数组，通过saList之后的List修改对应的值后，在运行时会报异常
        * 但是基本类型数组对应的List是会发生变化的，这是毫无疑问的
        *
        *
        * a_int_List.set(0,0);
        * foreach(a_int_List);foreach(a_int);
        * */
        System.out.println("段落4开始分割线-------");
        a_int[0]=5;
        foreachForBase(a_int_List);
        foreach(a_int);

    }

    /*打印方法*/
    private static void foreach(List list){
        for (Object object:list){
            System.out.println(object+" ");
        }
        System.out.println();
    }

    private static void foreachForBase(List a_int_List){
        int[] _a_int=(int[])a_int_List.get(0);
        foreach(_a_int);
    }

    private static void foreach(int[] a_int){
        for(int i:a_int){
            System.out.println(i+" ");
        }
        System.out.println();
    }

    private static void foreach(Integer[] _a_Integer){
        for(int i:_a_Integer){
            System.out.println(i+" ");
        }
        System.out.println();
    }
}
