class table
{
        void printTable(String name,int n)
        {
                 for(int i=1;i<=10;i++)
                {
                        try
                        {
                                System.out.println(name+": "+i);
                                Thread.sleep(4000);                                
                        }
                        catch(Exception e)
                        {
System.out.println(e);
                        }
                }
        }
}
class MyThread1 extends Thread
{
        table t;
        MyThread1(table t)
        {
                this.t=t;
        }
        public void run()
        {
                t.printTable("First thread",10);
        }
}
class MyThread2 extends Thread
{
        table t;
        MyThread2(table t)
        {
                this.t=t;
        }
        public void run()
        {
                t.printTable("Second thread",10);
        }
}
class MyThread3 extends Thread
{
        table t;
        MyThread3(table t)
        {
                this.t=t;
        }
        public void run()
        {
                t.printTable("Third thread",10);
        }
}
class Main
{
        public static int MIN_PRIORITY=1;
        public static int MAX_PRIORITY=10;
        public static void main(String []args)
        {
                table obj=new table();
                MyThread1 t1=new MyThread1(obj);
                MyThread2 t2=new MyThread2(obj);
                MyThread3 t3=new MyThread3(obj);
               
                t1.setPriority(MIN_PRIORITY);
                t2.setPriority(MIN_PRIORITY++);
                t3.setPriority(MAX_PRIORITY);
                        
                t1.start();
                t2.start();
                t3.start();
        }
}