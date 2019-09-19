package L26_FilesReadWrite.Task02;

public enum Direction {
    DOWN {
        @Override
        public void move(Dancer dancer) {
            dancer.count.y++;
            dancer.countless.y++;
        }
    },
    LEFT {
        public void move(Dancer dancer) {
            dancer.count.x--;
            dancer.countless.x--;
        }
    },
    RIGHT {
        public void move(Dancer dancer){
            dancer.count.x++;
            dancer.countless.x++;
        }
    },
    UP {
        public void move(Dancer dancer) {
            dancer.count.y--;
            dancer.countless.y--;
        }
    };
    public abstract void move(Dancer dancer);
}