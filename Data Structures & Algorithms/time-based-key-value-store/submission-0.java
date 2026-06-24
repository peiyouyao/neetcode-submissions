class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map=new HashMap<>();
    private int bs(List<Pair<Integer, String>> pairs, int tar){
        int l=0, r=pairs.size();
        while(l<r){
            int m=l+(r-l)/2;
            if(tar<=pairs.get(m).getKey())r=m;
            else l=m+1;
        }
        if(l<pairs.size() && pairs.get(l).getKey()==tar)return l;
        return -1-l;
    }

    public TimeMap(){}
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairs=map.get(key);
        if(pairs==null)return "";
        int idx=bs(pairs, timestamp);
        if(idx>-1)return pairs.get(idx).getValue();
        idx=-1-idx;
        if(idx>0)return pairs.get(idx-1).getValue();
        return "";
    }
}
