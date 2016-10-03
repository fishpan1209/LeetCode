public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iterLevel;
    Iterator<Integer> iterElement;

    public Vector2D(List<List<Integer>> vec2d) {
        this.iterLevel = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return iterElement.next();
    }

    @Override
    public boolean hasNext() {
        // empty cur list or reached end of cur list
        while((iterElement == null || !iterElement.hasNext()) && iterLevel.hasNext()) iterElement = iterLevel.next().iterator();
        return iterElement != null && iterElement.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
