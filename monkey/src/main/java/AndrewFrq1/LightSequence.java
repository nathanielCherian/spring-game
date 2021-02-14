package AndrewFrq1;

public class LightSequence
{
    public String seq;
   public String newSeq;
    public double thing;

    public LightSequence(String seq)
    {
        this.seq = seq;
    }

    public String insertSegment(String segment, int ind)

    { // implementation not shown
        String local = this.seq; //working with a local copy of the string
        String temp = local.substring(0,ind);
        local = temp.concat(segment+local);
        return local;
    }



    public void changeSequence(String seq)

    {
        this.seq =seq;
    }
    public void display()
    {
        System.out.println(seq);
    }
    public void remove(String oldSeq, String segment)
    {
        int start = oldSeq.indexOf(segment);
        if (start!=-1)
        {
//this.newSeq = oldSeq.substring(start,start+segment.length()); if you want the removed section
            this.newSeq = oldSeq.substring(0,start);
            this.newSeq = this.newSeq.concat(oldSeq.substring(start+segment.length()));
        }
        else
        {
            System.out.println("sorry substring wasn't found in the original string");
        }
        return;

    }
    //double a vertical
//double b horizontal
    public void printStraightline(double a, double b)
    {
        double display = Math.sqrt(((Math.pow(a,2))+(Math.pow(b,2))));
        this.thing = display;
        System.out.println("The straight line distance is: "+display);
    }
}
