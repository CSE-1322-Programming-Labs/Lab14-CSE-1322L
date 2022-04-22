public class BlueRayCollection {
    private Node head;

    BlueRayCollection(){
        head = null;
    }

    public void add(String title,String director,int yearOfRelease,double cost){
        if(head == null){
            head = new Node(new BlueRayDisk(title, director, yearOfRelease, cost));
            head.next = null;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(new BlueRayDisk(title, director, yearOfRelease, cost));
            temp.next.next = null;
        }
    }


    public void showAll(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
