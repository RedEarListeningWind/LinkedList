public class List<T> {
    private int number;
    private Elements<T> data;
    private List<T> previous;
    private  List<T> next;

    public List(){
        System.out.println("没有参数!");
    }

    public List(List<T> list, T str){

        if (list != null) {
            int i = 1;
            while (list.number >= 1) {
                if (list.next.number > i) {
                    list = list.next;
                    i++;
                } else {
                    add(list,str,++i);
                    break;
                }
            }
        }else {
            add(str);
        }
    }

    public List(List<T> list,T str,int j){

        if (list != null) {
            int n = list.previous.number + 1;
            list = list.previous;
            while (j<=n&&j>0) {

                if (n == j) {
                    add(list,str,j);
                    break;
                }else {
                    if (list.number == j){

                        list.number = list.number + 1;
                        add(list.previous,str,j);
                        break;
                    }else {
                        //this 及之后的number
                        list.number = list.number+1;
                        list = list.previous;
                    }
                    if (list.number == (n-1)){
                        break;
                    }
                }
            }
        }else if (j==1){
            add(str);
        }else {
            System.out.println("无法对空链表插入第"+j+"个数据");
        }
    }

    @Override
    public String toString() {
        return "List{" +
                "number=" + number +
                ", data=" + data.toString() +
                ", previous=" + (previous != null) +
                ", next=" + (next != null) +
                '}';
    }

    private void add(T str){

            this.next = this;
            this.previous = this;
            this.number = 1;

        this.data = new Elements<T>(str);

    }

    private void add(List<T> list,T str,int i){

            this.next = list.next;
            this.previous = list;
            list.next.previous = this;
            list.next = this;

            this.number = i;

        this.data = new Elements<T>(str);

    }

    public List<T> delete(){
        System.out.println("没有链表对象");
        return null;
    }
    public List<T> delete(List<T> list){
        List<T> popList = null;
        while (list != null){
            if (list.next.number == 1){
                list.previous.next = list.next;
                list.next.previous = list.previous;
                popList = list;
                popList.next = null;
                popList.previous = null;
                break;
            }
            list = list.next;
        }
        return popList;
    }
    public List<T> delete(List<T> list,int serial){
        List<T> popList = null;
        while (list != null) {
            if (list.number == serial){
                list.previous.next = list.next;
                list.next.previous = list.previous;
                popList = list;
                list = list.next;
                popList.next = null;
                popList.previous = null;

                continue;
            }else if (list.number > serial){
                list.number = list.number - 1;
            }
            if (list.next.number == 1){
                break;
            }
            list = list.next;
        }
        return popList;
    }

    public List<T> delete(List<T> list,int serial,int len){
        List<T> popList = null;
        while (list != null) {
            if (list.number == serial){
                List<T> lastOneList = list;
//                List previousList = list.previous;
                for (int k = 0;k<len;k++){
                    lastOneList = lastOneList.next;
                    if (lastOneList.number == 1){
                        break;
                    }
                }
                list.previous.next = lastOneList;
                lastOneList.previous = list.previous;


                popList = list;
                list = list.next;
                popList.next = null;
                popList.previous = null;

                continue;
            }else if (list.number > serial){
                list.number = list.number - len;
            }
            if (list.next.number == 1){
                break;
            }
            list = list.next;
        }
        return popList;
    }

    public String toLinkedList(List<T> list){
        int i = 1;
        String str = "";
        if (list != null) {
            while (list.number >= i) {

                str+=(list.toString() + "\n");
                list = list.next;
                i++;
            }
        }else {
            str+="无法对空链表读取数据";
        }
        return str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Elements<T> getData() {
        return data;
    }

    public void setData(Elements<T> data) {
        this.data = data;
    }

    public List<T> getPrevious() {
        return previous;
    }

    public void setPrevious(List<T> previous) {
        this.previous = previous;
    }

    public List<T> getNext() {
        return next;
    }

    public void setNext(List<T> next) {
        this.next = next;
    }
}

class Elements<T> {


    private T data;

    public Elements(){
        System.out.println("内容为空!");
    }


    public Elements(T dataOne){
        this.data = (T)dataOne;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Elements{" +
                "data=" + data +
                '}';
    }
}