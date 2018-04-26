package demo1;

import demo1.IShopPhone;

public class WJProxy implements IShopPhone {

    //持有目标引用对象
    private IShopPhone shopPhone;

    public WJProxy(IShopPhone shopPhone){
        this.shopPhone=shopPhone;
    }
    @Override
    public void shop(String phoneName) {
        this.shopPhone.shop(phoneName);
    }
}
