### 动态代理：

静态代理是编译时代理，动态代理是运行时代理

对于静态代理，如果我有一个类是找房子的，需要通过调用代理类；我有一个歌手类，我需要通过代理类代理唱歌，，等等。可能会出现很多的不同的代理类，既然你们都需要代理类，那么有没有可能有一个通用的代理类呢，但是编译时又不能确定下来，因为每一个代理类又是不一样的，所以需要在运行时动态的去创建对应的代理类



问题一：如何动态的根据被代理类创建一个代理类及其对象

问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的方法