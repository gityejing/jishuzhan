package annotation2.domain;

public class Car {

	public Car() {
		super();
		System.out.println("create ... ");
	}

	// 初始化方法
	public void init() {
		System.out.println("init ... ");
	}
	
	// 销毁方法
	public void destory() {
		System.out.println("destory ... ");
	}
}
