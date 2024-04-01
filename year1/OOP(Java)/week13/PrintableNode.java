// DO NOT MODIFY THIS CLASS

/** Node that can be printed */
public interface PrintableNode
{
    /** Get left child */
    PrintableNode getLeft();


    /** Get right child */
    PrintableNode getRight();


    /** Get text (i.e., ID of node) to be printed */
    String getText();
}
