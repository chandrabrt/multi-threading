#### 1.Introduction
#### 2. The way to define thread
- by extends Thread class
- by implementing Runnable Interface
#### 3.Getting and Setting name of thread
#### 4.Thread priorities
#### 5.The method to prevent thread execution

- yield()
- join()
- sleep()
#### 6. Synchronization
#### 7. Inter Thread communication
#### 8. DeadLuck
#### 9. Deamon Threads
#### 10. Multithreading  enhancement
--------------------------------------------------

#### Multitasking: *executing multiple task simultaneously.*
- Process based:
 
Executing multiple(several) task simultaneously where each task is a separate independent program(process)(each task running in separate
 thread, no dependencies between the task). It is based on OS level.
 
Here,the example below there are three independent programs(or may more).

Example: 
Typing a java program editor, listening audio from the same system, download a file.(no dependent between these task).

- Thread based multitasking: 

Executing multiple(several) task simultaneously where each task is a separate independent part of the same program(only one program).
Each independent part called thread. 

It is based on a programmatic level.

Here, there is only one program but may have several independent part(thread).


 #### Multi-threading: *executing multiple threads simultaneously.*
 Used to develop: 
 
 - multimedia graphics, animation, gaming, web/application server(eg. tomcat)
 
 Developing multithreaded application in java is very easy because provides inbuilt support for  multi-threading with rich
 API[Thread, Runnable, ThreadGroup..etc]
 
 #### What is Thread?
 - separate flow of execution
 - for every thread separate independent job required.
  
#### The way to define thread
- by extends Thread class
```
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
    }
}
```
- by implementing Runnable Interface

```
public class MyThread implements Runnable {
    
    @Override
    public void run() {
    }
}
```

#### Thread Scheduler: *is a part of JVM*

It is responsible to schedule threads that is if multiple thread are waiting to get the chance of execution then which
order thread will be executed is decided by thread scheduler. We can't expect exact which algorithm followed by thread 
scheduler, it is varied from JVM to JVM. Hence, we can't execution order and exact output. Hence,whenever situation comes 
to multithreading there is no guaratee for exact output, but we can provide several possible outputs.

#### Difference between start() and run()
```
public class Main {

    public static void main(String[] args) {
        /*
          In Main Thread there is only one thread and is responsible to start() other thread. Here,
          Child thread(MyThread class) is responsible to start run() method and Main Thread is responsible to
          run this main() method code.
         */
        MyThread myThread = new MyThread(); //Thread instantiation
        myThread.start(); //starting of thread

        for (int i=0; i<10; i++){
            System.out.println("Main Thread: "+ i);
        }
    }
}
```
```
public class MyThread extends Thread{
    @Override
    public void run() {
        //job of thread
        for (int i =0; i<=10; i++){
            System.out.println("Child Thread:"+ i);
        }
    }
}

```

In the case of myThread.start(), a new thread is created which is responsible for the execution of the run() method.

In the case of myThread.run() a new thread won't to be created, and the run() method will be executed just like a
normal method call by Main Thread.

Hence, the above program if replace myThread.start() with myThread.run() then the output is same order always. 
Example: The main Thread follows the child thread.
So always use start() to run thread.

#### start() method is responsible for:
```
{
   - Register the thread with thread scheduler
   - Perform all other mandatory activities
   - Invoke run() method
}
```
Hence, without executing thread class method there is no chance of starting a new thread in Java, dut to this
the thread class start() method consider as heart of multi-threading.

#### Is Thread overloading is possible?

```
public class ThreadOverloading extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("no args method:" + i);
        }
    }
    public void run(int i) {
        for (i = 0; i <= 2; i++) {
            System.out.println("args method:" + i);
        }
    }
}

class DemoThread {
    public static void main(String[] args) {
        ThreadOverloading t = new ThreadOverloading();
        t.start(); 
    }
}

output:
no args method: 1
no args method: 2 
```

Yes, thread overloading is possible but start() method always call the no-args run() method.

#### overriding the start() method

```
public class OveridingStart extends Thread {
    
    @Override
    public synchronized void start() {
        System.out.println("start method");
    }

    @Override
    public void run() {
        System.out.println("run method");
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        OveridingStart ot = new OveridingStart();
        ot.start();
        System.out.println("main method");
    }
}
/*
     output:
      start method
      main method
   */
```
If we override the start() method then our start() method will be executed just like a normal method call, and a 
new thread won't be created, because the thread start() method never call Thread class start() method. It is not 
recommended to override the start() method, otherwise don't go for multithreading concept.

```
public class OveridingStart extends Thread {
    
    @Override
    public synchronized void start() {
        super.start(); //super is used
        System.out.println("start method");
    }

    @Override
    public void run() {
        System.out.println("run method");
    }
}

class ThreadDemo{
    public static void main(String[] args) {
        OveridingStart ot = new OveridingStart();
        ot.start();
        System.out.println("main method");
    }
}

but if you use super.start() , the possible output are:
/*
     output:
      start method
      run method
      main method
or 
   run method
   start method
   main method

or 
     start method
     main method
     run method
   */
```
#### Thread Life-Cycle

![](src/com/us/lot/images/thradcycle.png)

###
After starting a thread if your are trying to restart the same thread we will get runtime exception:
IllegalThreadStateException

```
public class IllegalThreadException extends Thread{
    @Override
    public void run() {
        //job of thread
        System.out.println("Child Thread:");
    }
}

class Demo{
    public static void main(String[] args) {
        IllegalThreadException t = new IllegalThreadException();
        t.start();
        System.out.println("Main Thread");
        t.start();//IllegalThreadStateException
    }
}
//output:
Child Thread:
Main Thread
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:708)
	at com.us.lot.extendsthread.Demo.main(IllegalThreadException.java:19)
```

#### Runnable
```
public class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Child");
    }
}

class  Demo{
    public static void main(String[] args) {
        //Runnable
        MyRunnableThread myThread = new MyRunnableThread();

        Thread t1 = new Thread(myThread);
        t1.start();
        System.out.println("hello");
    }
}
```

#### Which approach is best approach?

Among two ways of defining a thread implement runnable approach is recommended.

In the first approach(extends thread), our class always extends Thread class, there is no chance of extending any other 
class.Hence, we are missing inheritance benefit and vice versa.

##### Thread class constructor

```
new Thread()
new Thread(Runnable var1);
new Thread(Runnable var1, AccessControlContext var2) 
new Thread(ThreadGroup var1, Runnable var2) 
new Thread(String var1)
new Thread(ThreadGroup var1, String var2) 
new Thread(Runnable var1, String var2) 
new Thread(ThreadGroup var1, Runnable var2, String var3) 
new Thread(ThreadGroup var1, Runnable var2, String var3, long var4);
```

#### Thread priorities

Every thread in java has some priority it may default priority generated by JVM, or customizable priority provided by 
a programmer. The valid range of thread priority is 1 to 10, where 1 is MIN priority and 10 is MAX priority. Thread class 
defined the following constants to represents some standard priority.

```
    Thread.MIN_PRIORITY = 1;
    Thread.NORM_PRIORITY = 5;
    Thread.MAX_PRIORITY = 10;
```
Thread scheduler will use priorities while allocating the processor.

The Thread which is having the highest priority will get chance first.

If two  thread having same priority e.g 7 and 7 then we can't expect exact execution order, it depends on thread scheduler.

The Thread class defined following method to get and the set priority of the thread:
```
public final int getPriority();
public final void setPriority(int p);
```
Allowed values range 1 to 10, otherwise throw runtime exception IllegalArgumentException.

```example:
    t.setPriority(17) //throw exception
```
#### Default priority 

The default priority only for the Main thread is 5, but all the remaining thread default priority will be inherited from
parent to child i.e. what ever the Parent Thread have the same priority will be there for the Child Thread.
```
Example: 
public class ThreadPriority implements Runnable {
    @Override
    public void run() {

    }
}

class PriorityMain{

    public static void main(String[] args) {
        System.out.println("default priority main thread: "+ Thread.currentThread().getPriority());//5

        Thread.currentThread().setPriority(7);
        System.out.println("after setting parent priority: "+ Thread.currentThread().getPriority()); //7

        ThreadPriority runnable = new ThreadPriority();
        Thread thread = new Thread(runnable);

        System.out.println("Child priority: "+ thread.getPriority());//7

    }
}
```
Note: some platforms won't proper support for thread priorities. Here,even I set priority 7  which is more highest priority 
than default Main Thread priority(5)

```
Example: 
public class ThreadPriority implements Runnable {
    @Override
    public void run() {

    }
}

class PriorityMain{

    public static void main(String[] args) {
        System.out.println("default priority main thread: "+ Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(7);
        System.out.println("after setting parent priority: "+ Thread.currentThread().getPriority());

        ThreadPriority runnable = new ThreadPriority();
        Thread thread = new Thread(runnable);

        System.out.println("Child priority: "+ thread.getPriority());

    }
}
```

#### Prevent Thread execution:

we can prevent a thread execution by using the following methods:
- yield()
- join()
- sleep()

##### yield():

- yield() method causes to pausing current executing thread to give the chance for waiting threads of same priority.

- If there is no waiting threads or all waiting thread have low priority then same thread can continue its execution.

- If multiple threads(t1,t2,t3,t4) are waiting with same priority(e.g 7) then which waiting thread will get the chance 
we can't expect it depends on thread scheduler.

- The thread which is yielded(e.g t1), it will get the chance once again it depends on thread scheduler and, we can't 
expect exactly.
```
public static native void yield()
```
![](src/com/us/lot/images/yield.png)
```
Example:
public class YieldExpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Child thread");
            Thread.yield(); ----------(I)
        }
    }
}

class Demo {

    public static void main(String[] args) {
        YieldExpThread t = new YieldExpThread();
        t.start();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Main thread");
        }

    }
}
```
In the above program, if we are commenting line(I) then both thread will be executed simultaneously and, we can't expect 
which thread will complete first.

If we are not commenting line then child thread always called yield() method because of that main thread will get a chance
more number of times, and the chance of completing main thread first is high.

Note: Some platform won't provide proper support for yield() method.


##### join()

If a thread wants to wait until completing some other thread then we should go for join() method.

For example: if a thread t1 wants to wait until completing t2 then t1 has to call  t2.join().

If t1 executes t2.join() then immediately t1 will be entered into waiting state until t2  completes.Once a t2 complete then
t1 can continue its execution.
```
 public final void join() throws InterruptedException;
public final synchronized void join(long ms) throws InterruptedException;
public final synchronized void join(long ms, int ns) throws InterruptedException;
```
![](src/com/us/lot/images/join.png)

```
public class JoinExpThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++){
            System.out.println("Child thread");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

class TestDemo{
    public static void main(String[] args) throws InterruptedException {
        JoinExpThread t = new JoinExpThread();
        t.start();
        //main thread running
        t.join(); ///main thread is completed until child thread is complted

        for (int i = 0; i <=10 ; i++){
            System.out.println("Main thread");
        }
    }

    /*output:
     * Child thread
Child thread
Child thread
..........
Main thread
Main thread
..........
     */
}
```
**Deadlock cases with join() method:**

The below example,if the main thread calls join() method on child thread object and child thread call join() method on 
main thread object then both the thread will wait forever, and the program will be pause(stuck).
```Example1:
public class StaticJoinExpThread extends Thread {

    static Thread mt; //mt = main thread reference

    @Override
    public void run() {
        try {
            mt.join(); //child thread waiting to complete main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i<=10; i++){
            System.out.println("Child thread");
        }
    }
}

class ThreadJoinDemo{

    public static void main(String[] args) throws InterruptedException {
        StaticJoinExpThread.mt = Thread.currentThread(); //mt point into main thread i.e mt assign Main Thread

        StaticJoinExpThread t = new StaticJoinExpThread();
        t.start();
        t.join(); //here, main thread is waiting until child thread is completed, this cause dead lock because child thread main thread  both call join method and wait until completed each. so don't call join() method both in child and main thread
        for (int i = 1; i<=10; i++){
            System.out.println("main thread");
            Thread.sleep(2000);
        }
    }
}
 output: nothing

```
The below example, if a thread calls join() method on the same thread itself then the program will stucked(paused). In this
case thread has to wait infinite amount of time.

```
Example 2:
class ThreadJoinDemo{
   
       public static void main(String[] args) throws InterruptedException {
           Thread.currentThread().join();
  }
}
 output: nothing
```
##### sleep()

If your thread don't want to perform any operation for a particular amount of time then we should go for sleep() method.
```
    public static native void sleep(long ms) throws InterruptedException;
    public static void sleep(long ms, int ns) throws InterruptedException;
```
![](src/com/us/lot/images/sleep.png)
















 