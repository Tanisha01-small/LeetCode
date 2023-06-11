class SnapshotArray {
    private Map<Integer,TreeMap<Integer,Integer>> snaps;
    private int snapid;

    public SnapshotArray(int length) {
        snaps=new HashMap<>();
        snapid=0;
        for(int i=0;i<length;i++){
            TreeMap<Integer,Integer> map=new TreeMap<>();
            map.put(0,0);
            snaps.put(i,map);
        }
    }
    
    public void set(int index, int val) {
        snaps.get(index).put(snapid,val);
    }
    
    public int snap() {
        return snapid++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer,Integer> map=snaps.get(index);
        Integer value =map.floorKey(snap_id);
        if(value==null){
            return 0;
        }
        return map.get(value);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */