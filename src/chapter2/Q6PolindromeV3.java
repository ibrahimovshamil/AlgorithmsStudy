package chapter2;

public class Q6PolindromeV3 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2).appendToTail(3).appendToTail(2).appendToTail(1);
        System.out.println("Result: " + isPolindrome(node));
        double area = 0.0;
        int a  = (int) (Math.PI * 5.0);
    }

    public static boolean isPolindrome(Node n) {
        int length = length(n);
        int counter = 0;
        boolean odd = length % 2 == 1 ? true : false;

        Node r = new Node(0);
        Result res = new Result();
        Result result = isPolindrome(n, res, (int) Math.ceil(length / 2.0), odd, 1);
        return result.result;
    }

    //We can use the returned Result obj instead of _result... my bad... np still learning :)
    private static Result isPolindrome(Node l, Result _result, int length, boolean odd, int counter) {
        if (counter == length && odd) {
            Result res = new Result();
            res.result = true;
            _result.node = l.next;
            return res;
        } else if (counter == length && !odd) {
            Result res = new Result();
            _result.node = l.next;
            res.result = _result.node.data == l.data ? true : false;
            _result.node = _result.node.next;
            return res;
        }

        Result res = isPolindrome(l.next, _result, length, odd, ++counter);
        if (l.data == _result.node.data && res.result) {
            res.result = true;
        } else res.result = false;

        _result.node = _result.node.next;
        return res;

    }

    private static int length(Node n) {
        int counter = 0;
        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }

    static class Result {
        boolean result = true;
        Node node;
    }


}
