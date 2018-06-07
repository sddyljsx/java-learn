package neal.java.effectivejava._2objects;

/**
 * Item	3:	Enforce	the	singleton	property	with	a	private
 constructor	or	an	enum	type
 * 枚举单例
 */
public class _3 {

    public enum Elvis {
        INSTANCE;

        public void leaveTheBuilding() {	}
    }
}
