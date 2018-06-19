package neal.java.effectivejava._6enum;

/**
 * Item	34:	Use	enums	instead	of	int	constants
 */
public class _34 {

    public enum Apple {FUJI, PIPPIN, GRANNY_SMITH}

    public enum Orange {NAVEL, TEMPLE, BLOOD}

    public enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6),
        MARS(6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN(5.685e+26, 6.027e7),
        URANUS(8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);
        private final double mass;    //	In	kilograms private
        private	final	double	radius;	//	In	meters
        private final double surfaceGravity;    //	In	m	/	s^2
        //	Universal	gravitational	constant	in	m^3	/	kg	s^2
        private static final double G = 6.67300E-11;

        //	Constructor
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass() {
            return mass;
        }

        public double radius() {
            return radius;
        }

        public double surfaceGravity() {
            return surfaceGravity;
        }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity;    //	F	=	ma
        }
    }


    public	enum	Operation	{
        PLUS("+")	{
            public	double	apply(double	x,	double	y)	{	return	x	+	y;	}
        },
        MINUS("-")	{
            public	double	apply(double	x,	double	y)	{	return	x	-	y;	}
        },
        TIMES("*")	{
            public	double	apply(double	x,	double	y)	{	return	x	*	y;	}
        },
        DIVIDE("/")	{
            public	double	apply(double	x,	double	y)	{	return	x	/	y;	}
        };
        private	final	String	symbol;
        Operation(String	symbol)	{	this.symbol	=	symbol;	}
        @Override	public	String	toString()	{	return	symbol;	}
        public	abstract	double	apply(double	x,	double	y);
    }

    public	static	void	main(String[]	args)	{
        double	x	=	Double.parseDouble("1.23");
        double	y	=	Double.parseDouble("2.0");
        for	(Operation	op	:	Operation.values())System.out.printf("%f	%s	%f	=	%f%n",
                x,	op,	y,	op.apply(x,	y));
    }
}
