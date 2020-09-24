import java.util.Scanner;

public class LinkedList<T> {
    private String name;
    private List<T> list;
    private int I_listNumber;

    public LinkedList(String Iname){
        name = Iname;
        list = null;
        I_listNumber = 0;
    }

    public LinkedList(T str,String Iname){
        name = Iname;
        list = null;
        I_listNumber = 0;
        list = establish(str);
    }
    public static void main(String[] args) {


        LinkedList<LinkedList<String>> linkedList = new LinkedList<LinkedList<String>>("main");;
        int serial = 7;
        int frequency = 0;

        while (serial!=8) {


            switch (serial) {
                case 1:
                    //1.创建新链表
                    System.out.print("请输入第一条内容:");
                    Scanner sc = new Scanner(System.in);
                    String str1 = "";
                    if (sc.hasNext()) {
                        str1 = sc.nextLine();
                    }
                    //linkedList = new LinkedList<LinkedList<String>>(new LinkedList<String>("第一条", "第"+frequency+"条双向链表"), "main");

                    linkedList.list = linkedList.establish(new LinkedList<String>(str1,"第"+(++frequency)+"条双向链表"));
                    break;
                case 2:
                    //2.增加数据
                    System.out.print("请输入内容:");
                    Scanner add = new Scanner(System.in);
                    String str2 = "";
                    if (add.hasNext()) {
                        str2 = add.nextLine();
                    }
                    linkedList.list.getData().getData().establish(str2);
                    break;
                case 3:
                    //3.删除数据
                    System.out.println(linkedList.list.getData().getData().delete());
                    break;
                case 4:
                    //4.删除链表

                    break;
                case 5:
                    //5.修改数据
                    break;
                case 6:
//                    System.out.println(linkedList.list.getData().getData().list.getData().getData());
                    System.out.println(linkedList.toString());
                    break;
                case 7:
                    //7.提示
                    LinkedList.Tips();
                    break;
                default:
                    //8.退出
                    break;
            }
            serial = 0;
            Scanner ioInt = new Scanner(System.in);
            System.out.print("请输入命令:");
            if (ioInt.hasNextInt()) {
                serial = ioInt.nextInt();
            }
            //sc.nextInt()
        }






        /*for (int i=0;i<6;i++) {

        }
        for (int n = 1;n<8;n++) {
            linkedList.establish(new LinkedList<String>("插入第" + (n + 1) + "条","插入第"+ (n+1)), 6);
        }
        System.out.println(linkedList.toString());*/
        /*for (int k = 1;k<3;k++){
            System.out.println(linkedList.delete(linkedList.list,1).toString());;
        }*/

//        linkedList.delete(linkedList.list,5,3);
        /*System.out.println(linkedList.toString());
//        linkedList.list.getData().getData().list;
        System.out.println(linkedList.list.getData().getData().list.getData().getData());
*/
    }

    public static void Tips(){
        System.out.println("\t\t双向链表\n"+
                "{1.创建新链表,\t"+
                "2.增加数据,\t"+
                "3.删除数据,\t"+
                "4.删除链表,\t"+
                "5.修改数据,\t"+
                "6.查看数据,\t"+
                "7.提示,\t"+
                "8.退出}");
    }

    public List<T> establish(T str){
        List<T> addList = new List<T>(getList(),str);
        if (addList != null) {
            setI_listNumber(getI_listNumber() + 1);
        }
        return addList;
    }

    public List<T> establish(T str,int j){
        List<T> addList = new List<T>(this.getList(),str,j);
        if (addList != null) {
            if (j == 1) {
                setList(addList);
            }
            setI_listNumber(getI_listNumber() + 1);
        }
        return addList;
    }

    public List<T> delete(){
        List<T> popList = list.delete(this.getList());
        if (popList != null) {
            setI_listNumber(getI_listNumber() - 1);
        }
        return popList;
    }

    public List<T> delete(int n){
        if (n == 1) {
            setList(this.getList().getNext());
        }
        List<T> popList = this.getList().delete(this.getList(),n);
        if (popList != null) {

            setI_listNumber(getI_listNumber() - 1);
        }
        return popList;
    }

    public List<T> delete(int n,int len){
        if (n == 1) {
            List<T> newList = this.getList();
            for (int k= 0;k<len;k++){
                newList = newList.getNext();
            }
            setList(newList);
        }
        List<T> popList = this.getList().delete(this.getList(),n,len);
        if (popList != null) {

            setI_listNumber(getI_listNumber() - len);
        }
        return popList;
    }

    @Override
    public String toString() {
        String str = "";
        if (list != null){
            str = list.toLinkedList(list);
        }
        return "LinkedList{" +
                "name='" + name + "'," +
                "list=" + (list!=null) +
                ", I_listNumber=" + I_listNumber +
                "}\n"+str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getI_listNumber() {
        return I_listNumber;
    }

    public void setI_listNumber(int i_listNumber) {
        I_listNumber = i_listNumber;
    }
}
