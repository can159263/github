package cn.szboc.component.random;

import cn.szboc.platform.component.random.RandomMap;

public class RandomMapTest {

	public static void main(String[] args) {
		
		final RandomMap<String, String> map = new RandomMap<String, String>();
		
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				for(int i = 0; i <= 10; i ++){
					map.get("A");
				}
			}
			
		}).start();
		
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				for(int i = 0; i <= 10; i ++){
					map.get("A");
				}
			}
			
		}).start();
		
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				for(int i = 0; i <= 10; i ++){
					map.put("A", "A");
				}
			}
			
		}).start();
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				for(int i = 0; i <= 10; i ++){
					map.put("A", "A");
				}
			}
			
		}).start();
		
	}

}
