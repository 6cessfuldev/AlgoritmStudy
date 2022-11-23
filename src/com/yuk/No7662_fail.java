package com.yuk;

import java.util.Scanner;

class MaxQueue {
	int maxSize;
	int[] queArr;
	int back;
	
	public MaxQueue(int maxSize) {
		this.maxSize = maxSize;
		this.queArr= new int[maxSize+1];
		back = 1;
	}
	
	public boolean isEmpty() {
		if(back<=1) {
			return true;
		}
		return false;
	}
	
	public void push(int value) {
		if(isFull()) return;
		
		int tmp = back++;
		while(tmp>1) {
			if(value>queArr[tmp/2]) {
				queArr[tmp] = queArr[tmp/2];
				tmp = tmp/2;
			} else {
				break;
			}
		}
		
		queArr[tmp] = value;
	}
	
	public boolean isFull() {
		if(back>=maxSize+1) {
			return true;
		}
		return false;
	}

	public int poll() {

		int result = queArr[1];

		back--;
		int tmp = 1;
		while(2*tmp<back) {
			
			if(back>tmp*2+1) {
				int bigger = (queArr[tmp*2] >= queArr[tmp*2+1]) ? tmp*2 : tmp*2+1;
				if(queArr[back]>queArr[bigger]) {
					break;
				} else {
					queArr[tmp]=queArr[bigger];
					tmp = bigger;
				}
			} else {
				if(queArr[back]>queArr[tmp*2]) {
					break;
				} else {
					queArr[tmp]=queArr[tmp*2];
					tmp = tmp*2;
				}
			}
		}
		queArr[tmp] = queArr[back];
		
		return result;
	}
	
	public void remove(int n) {
		if(isEmpty()) return;
		back--;
		int tmp = 1;
		for (int i =back ; i > 0; i--) {
			if(queArr[i]==n) {
				tmp=i;
				break;
			}
		}
		if(tmp == back) return;
		
		while(2*tmp<back) {
		
			if(back>tmp*2+1) {
				int bigger = (queArr[tmp*2] >= queArr[tmp*2+1]) ? tmp*2 : tmp*2+1;
				if(queArr[back]>queArr[bigger]) {
					break;
				} else {
					queArr[tmp]=queArr[bigger];
					tmp = bigger;
				}
			} else {
				if(queArr[back]>queArr[tmp*2]) {
					break;
				} else {
					queArr[tmp]=queArr[tmp*2];
					tmp = tmp*2;
				}
			}
		}
		
		queArr[tmp] = queArr[back];
	}
}

class MinQueue {
	int maxSize;
	int[] queArr;
	int back;
	
	public MinQueue(int maxSize) {
		this.maxSize = maxSize;
		this.queArr= new int[maxSize+1];
		back = 1;
	}
	
	public boolean isEmpty() {
		if(back<=1) {
			return true;
		}
		return false;
	}
	
	public void push(int value) {
		if(isFull()) return;
		
		int tmp = back++;
		while(tmp>1) {
			if(value<queArr[tmp/2]) {
				queArr[tmp] = queArr[tmp/2];
				tmp = tmp/2;
			} else {
				break;
			}
		}
		
		queArr[tmp] = value;
	}
	
	public boolean isFull() {
		if(back>=maxSize+1) {
			return true;
		}
		return false;
	}

	public int poll() {
		int result = queArr[1];
		
		back--;
		int tmp = 1;
		while(2*tmp<back) {
			
			if(back>tmp*2+1) {
				int smaller = (queArr[tmp*2] <= queArr[tmp*2+1]) ? tmp*2 : tmp*2+1;
				if(queArr[back]<queArr[smaller]) {
					break;
				} else {
					queArr[tmp]=queArr[smaller];
					tmp = smaller;
				}
			} else {
				if(queArr[back]<queArr[tmp*2]) {
					break;
				} else {
					queArr[tmp]=queArr[tmp*2];
					tmp = tmp*2;
				}
			}
		}
		queArr[tmp] = queArr[back];
		
		return result;
	}
	
	public void remove(int n) {
		if(isEmpty()) return;
		back--;
		
		int tmp = 1;
		for (int i =back ; i > 0; i--) {
			if(queArr[i]==n) {
				tmp=i;
				break;
			}
		}
		
		if(tmp == back) return;
		
		while(2*tmp<back) {
		
			if(back>tmp*2+1) {
				int smaller = (queArr[tmp*2] <= queArr[tmp*2+1]) ? tmp*2 : tmp*2+1;
				if(queArr[back]<queArr[smaller]) {
					break;
				} else {
					queArr[tmp]=queArr[smaller];
					tmp = smaller;
				}
			} else {
				if(queArr[back]<queArr[tmp*2]) {
					break;
				} else {
					queArr[tmp]=queArr[tmp*2];
					tmp = tmp*2;
				}
			}
		}
		
		queArr[tmp] = queArr[back];
	}
}

public class No7662_fail {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			
			int k = scan.nextInt();
			MaxQueue maxq = new MaxQueue(k);
			MinQueue minq = new MinQueue(k);
			
			for (int j = 0; j < k; j++) {
				
				String op = scan.next();
				int n = scan.nextInt();
				if(op.equals("I")) {
					maxq.push(n);
					minq.push(n);
				}else {
					if(n==1) {
						if(!maxq.isEmpty()) {
							minq.remove(maxq.poll());					
						}
					}
					else {
						if(!maxq.isEmpty()) {
							maxq.remove(minq.poll());
						}
					}
				}
			}
			
			if(maxq.isEmpty()) {
				sb.append("EMPTY");
			}else { 
		
				int max = maxq.queArr[1];
				int min = minq.queArr[1];
				
				sb.append(max+" "+min);
				
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
