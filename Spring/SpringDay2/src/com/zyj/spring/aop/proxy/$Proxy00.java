package com.zyj.spring.aop.proxy;

import com.zyj.spring.aop.proxy.ArithmeticCalculator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy00 extends Proxy implements ArithmeticCalculator {
	private static Method m1;
	private static Method m2;
	private static Method m4;
	private static Method m3;
	private static Method m6;
	private static Method m5;
	private static Method m0;

	public $Proxy00(InvocationHandler arg0) throws Exception {
      super(arg0);
   }

	public final boolean equals(Object arg0) {
      try {
         return ((Boolean)super.h.invoke(this, m1, new Object[]{arg0})).booleanValue();
      } catch (RuntimeException | Error arg2) {
         throw arg2;
      } catch (Throwable arg3) {
         throw new UndeclaredThrowableException(arg3);
      }
   }

	public final String toString() {
      try {
         return (String)super.h.invoke(this, m2, (Object[])null);
      } catch (RuntimeException | Error arg1) {
         throw arg1;
      } catch (Throwable arg2) {
         throw new UndeclaredThrowableException(arg2);
      }
   }

	public final int mul(int arg0, int arg1) {
      try {
         return ((Integer)super.h.invoke(this, m4, new Object[]{Integer.valueOf(arg0), Integer.valueOf(arg1)})).intValue();
      } catch (RuntimeException | Error arg3) {
         throw arg3;
      } catch (Throwable arg4) {
         throw new UndeclaredThrowableException(arg4);
      }
   }

	public final int add(int arg0, int arg1) {
      try {
         return ((Integer)super.h.invoke(this, m3, new Object[]{Integer.valueOf(arg0), Integer.valueOf(arg1)})).intValue();
      } catch (RuntimeException | Error arg3) {
         throw arg3;
      } catch (Throwable arg4) {
         throw new UndeclaredThrowableException(arg4);
      }
   }

	public final int sub(int arg0, int arg1) {
      try {
         return ((Integer)super.h.invoke(this, m6, new Object[]{Integer.valueOf(arg0), Integer.valueOf(arg1)})).intValue();
      } catch (RuntimeException | Error arg3) {
         throw arg3;
      } catch (Throwable arg4) {
         throw new UndeclaredThrowableException(arg4);
      }
   }

	public final int div(int arg0, int arg1) {
      try {
         return ((Integer)super.h.invoke(this, m5, new Object[]{Integer.valueOf(arg0), Integer.valueOf(arg1)})).intValue();
      } catch (RuntimeException | Error arg3) {
         throw arg3;
      } catch (Throwable arg4) {
         throw new UndeclaredThrowableException(arg4);
      }
   }

	public final int hashCode() {
      try {
         return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
      } catch (RuntimeException | Error arg1) {
         throw arg1;
      } catch (Throwable arg2) {
         throw new UndeclaredThrowableException(arg2);
      }
   }

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
			m4 = Class.forName("com.atguigu.spring.aop.proxy.ArithmeticCalculator").getMethod("mul",
					new Class[]{Integer.TYPE, Integer.TYPE});
			m3 = Class.forName("com.atguigu.spring.aop.proxy.ArithmeticCalculator").getMethod("add",
					new Class[]{Integer.TYPE, Integer.TYPE});
			m6 = Class.forName("com.atguigu.spring.aop.proxy.ArithmeticCalculator").getMethod("sub",
					new Class[]{Integer.TYPE, Integer.TYPE});
			m5 = Class.forName("com.atguigu.spring.aop.proxy.ArithmeticCalculator").getMethod("div",
					new Class[]{Integer.TYPE, Integer.TYPE});
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
		} catch (NoSuchMethodException arg1) {
			throw new NoSuchMethodError(arg1.getMessage());
		} catch (ClassNotFoundException arg2) {
			throw new NoClassDefFoundError(arg2.getMessage());
		}
	}
}
