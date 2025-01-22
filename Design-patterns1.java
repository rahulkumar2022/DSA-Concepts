----------------------
// Single Ton pattern
public class MainThread{
	public static MainThread instance;
	private MainThread(){
		
	}
	public static MainThread getInstance(){
		if(instance==null){
			synchronized(MainThread.class){
				if(instance==null){
					instance = new MainThread();
				}
			}
		}
		return instance;
	}
}
-----------------------------------
// Factory Design Pattern
public abstract class OperatingSystem{
	private String version;
	private String architecture;
	
	public String getVersion(){
		return version;
	}
	
	public void setVersion(String version){
		this.version = version;
	}
	
	public String getArchitecture(){
		return architecture;
	}
	
	public void setArchitecture(String architecture){
		this.architecture = architecture;
	}
	
	public OperatingSystem(String version,String architecture){
		this.version = version;
		this.architecture = architecture;
	}
	
	public abstract void changeDirectory(String dir);
	public abstract void removeDir(String dir);
}
public class LinuxOperatingSystem extends OperatingSystem{
	public LinuxOperatingSystem(String version,String architecture){
		super(version,architecture);
	}
	@Override
	public void changeDirectory(String dir){
		// My Linux implementation
	}
	@Override
	public void removeDir(String dir){
		// My Linux implemntation
	}
}
public class WindowOperaingSystem extends OperatingSystem{
	public WindowOPeratingSystem(String version,String architecture){
		super(version,architecture);
	}
	@Override
	public void changeDirectory(String dir){
		// Windows implemntation
	}
	@Override
	public void removeDir(String dir){
		// Window implementation
	}
}
public OperatingSystemFactory{
	private OperatingSystem(){
		
	}
	public static OpeartingSystem getInstance(String version,String architecture,String os){
		switch(os){
			case "WINDOWS" : return new WindowsOperatingSystem(version,architecture);
			case "LINUX" : return new LinuxOperatingSystem(version,architecture);
			default : throw new IllegalArgumentExtection("Not a valid OS");
		}
	}
}
----------------------------------
// Abstract Factory Design Pattern
public interface UIFactory{
	Button createButton();
	CheckBoc createCheckBox();
}
public interface Button{
	void paint();
}
public interface CheckBox{
	void paint();
}
public class WindowButton implements Button{
	void paint(){
		// Windows logic
	}
}
public class MacButton implements Button{
	void paint(){
		// Mac implementation
	}
}
//Similarly can implement for checkbox
public class WindowsUIFactory implements UIFactory{
	@Override
	public Button createButton(){
		return new WindowButton();
	}
	@Override
	public Checkbox createCheckBox(){
		return new WindowCheckBox();
	}
}
public class MacUIFactory implements UIFactory{
	@Override
	public Button createButton(){
		return new MacButton();
	}
	@Override
	public Checkbox createCheckBox(){
		return new MacCheckBox();
	}
}
public class Application{
	private Button button;
	private Checkbox checkBox;
	public Application(UIFactory factory){
		this.button = factory.createButton();
		this.checkbox = factory.createCheckBox();
	}
	public void paint(){
		this.button.paint();
		this.checkBox.paint();
	}
}
Application application = new Application(new WindowUIFactory());
application.paint();
----------------------------------------
// Strategy Design Pattern
public interface PaymantStrategy{
	String processPayment(double amount);
}
public class PaypalStrategy implements PaymantStrategy{
	@Override
	public String processPayment(double amount){
		return "Payment done by Paypal, Amount: "+amount;
	}
}
public class StripeStrategy implements PaymantStrategy{
	@Override
	public String processPayment(double amount){
		return "Payemnt done by Stripe, Amount: ":amount;
	}
}
public class PaymentProcessor{
	private PaymantStrategy paymantStrategy;
	public PaymentProcessor(PaymantStrategy strategy){
		this.paymantStrategy = strategy;
	}
	public String processPayment(double amount){
		return paymantStrategy.processPayment(amount);
	}
	public void setPaymantStrategy(PaymantStrategy strategy){
		this.paymantStrategy = strategy;
	}

}
public class Main{
	publiv static void main(String[] args){
		PaymantStrategy paypal = new PaypalStrategy();
		PaymantStrategy stripe = new StripeStrategy();
		PaymentProcessor paymentProcessor = new PaymentProcessor(paypal);
		double amount = 100;
		String result = paymentProcessor.processPayment(amount);
		System.out.println(result);
		paymentProcessor.setPaymantStrategy(stripe);
		result = paymentProcessor.processPayment(stripe);
		System.out.println(result);
	}
}
-----------------------------------------------
// Observer Design Patter
public interface Observer{
	void update(String data);
}
public interface Subject{
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers(String data);
}
public class WeatherService implements Subject{
	private List<Observer> observers;
	private String data;

	public WeatherService(){
		this.observers = new ArrayList<>();
	}
	@Override
	public void registerObserver(Observer observer){
		observers.add(observer);
	}
	@Override
	public void removeObserver(Observer observer){
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String data){
		this.data = data;
		for(Observer observer:observers) {
			observer.update(data);
		}
	}
	public void setData(String data){
		notifyObservers(data);
	}

}
public class WeatherDisplay implements Observer{
	private String name;
	private String data;

	public WeatherDisplay(String name){
		this.name = name;
	}

	@Override
	public void update(String data){
		this.data = data;
		display();
	}
	public void display(){
		System.out.println(name+" recieved weather data "+data);
	}
}
public class Main{
	public static void main(String[] args){
		WeatherService weatherService = new WeatherDisplay();
		WeatherDisplay display1 = new WeatherDisplay("Screen 1");
		WeatherDisplay display2 = new WeatherDisplay("Screen 2");

		weatherService.registerObserver(display1);
		weatherService.registerObserver(display2);

		weatherService.setData("sunny");
		weatherService.setData("Rainy");
	}
}
-------------------------------------------------
// Descorator Design Pattern
public abstract class BasePizza{
	public abstract int cost(String size);
}
public class FarmHouse extends BasePizza{
	@Oveeride
	public int cost(String size){
		if(size.ignoreCase().equals("Regular")) return 150;
		else if(size.ignoreCase().equals("medium")) return 200;
		else if(size.ignoreCase().equals("large")) return 250;
		throw new IllegalArgumentException("Invalid size");
	}
}
public class Margarita extends BasePizza{
	@Oveeride
	public int cost(String size){
		if(size.ignoreCase().equals("Regular")) return 100;
		else if(size.ignoreCase().equals("medium")) return 150;
		else if(size.ignoreCase().equals("large")) return 200;
		throw new IllegalArgumentException("Invalid size");
	}
}
public abstract class ToppingDecorator extend BasePizza{
	public abstract int cost();
}
public class ExtractChesse extends ToppingDecorator{
	BasePizza basePizza;
	public ExtractChesse(BasePizza pizza){
		this.basePizza = pizza;
	}
	@Override
	public int cost(){
		return this.basePizza.cost() + 70;
	}
}
public class MushRoom extends ToppingDecorator{
	BasePizza basePizza;
	public ExtractChesse(BasePizza pizza){
		this.basePizza = pizza;
	}
	@Override
	public int cost(){
		return this.basePizza.cost() + 40;
	}
}
BasePizza pizza = new ExtractChesse(new Margarita());
BasePizza pizza2 = new MushRoom(new ExtractChesse(new FarmHouse()));
----------------------------------------------
// Chain of responsibility
public abstract class LogProcessor{
	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int ERROR = 3;
	LogProcessor nextLogProcessor;
	LogProcessor(LogProcessor logProcessor){
		this.nextLogProcessor = logProcessor;
	}
}
---------------------------------------------
// Hashmap internal implementation
public class MyHashMap<K,V>{
	private static final int INITIAL_SIZE = 1<<4;
	private static final int MAXIMUM_CAPACITY = 1<<30;
	public Entry[] hashTable;
	public MyHashMap(){
		this.hashTable = new Entry[INITIAL_SIZE];
	}
	public MyHashMap(int cap){
		int tableSize = tableSizeFor(cap);
		this.hashTable = new Entry[tableSize];
	}
	public final tableSizeFor(int cap){
		int n = cap-1;
		n |= n>>>1;
		n |= n>>>2;
		n |= n>>>4;
		n |= n>>>8;
		n |= n>>>16;
		return (n<0)?1:(n>=MAXIMUM_CAPACITY):MAXIMUM_CAPACITY:n+1;
	}
	class Entry<K,V>{
		public K key;
		public V value;
		public Entry next;
		Entry(K k,V v){
			this.key = K;
			this.value = V;
		}
		public void put(K key,V value){
			int hashCode = key.hashCode()%hashTable.length;
			Entry node = hashTable[hashCode];
			if(node==null){
				Entry newNode = new Entry(key,value);
				hashTable[hashCode] = newNode;
			}
			else{
				Entry prevNode = Node;
				while(!node=null){
					if(node.key==key) {
						node.value = value;
						return;
					}
					prevNode = node;
					node = node.next;
				}
				Entry newNode = new Entry(key, value);
				prevNode.next = newNode;

			}

		}
	}
	public V get(K key){
		int hashCode = key.getHashCode()%hashTable.length;
		Entry Node = hashTable[hashCode];
		while(!node=null){
			if(node.key.equals(key)){
				return (V)node.value;
			}
			node = node.nextl
		}
		return null;
	}
}
MyHashMap<Integer,String> map = new HashMap<>();
--------------------------------------------
// Composite Design pattern
//Way 1:-
class Directory{
	String directoryName;
	List<Object> objectList;
	public Directory(String name){
		this.directoryName = name;
		objectList = new ArrayList<>();
	}
	public void add(Object object){
		objectList.add(object);
	}
	public void ls(){
		System.out.println("Directory name "+directoryName);
		for(Object obj:objectList){
			if(obj instanceof File) (File)obj.ls();// Problem
			else if(obj instanceof Directory) (Directory)obj.ls();// Problem
		}
	}
}
// Solution
public interface FileSystem{
	public void ls();
}
public class File implements FileSystem{
	String fileName;
	public File(String name){
		this.fileName = name;
	}
	public void ls(){
		System.out.println("File name : "+fileName);
	}
}
public class Directory implements FileSystem{
	String directoryName;
	List<FileSystem> fileSystemList;
	public Directory(String name){
		this.directoryName = name;
		fileSystemList = new ArrayList<>();
	}
	public void add(FileSystem fileSystemObj){
		fileSystemList.add(fileSystemObj);
	}
	public void ls(){
		System.out.println("Directory name "+directoryName);
		for(FileSystem fileSystemObj: fileSystemList){
			fileSystemObj.ls();
		}
	}
}
