//@+leo-ver=5-thin
//@+node:roobie.20110516104530.1328: * @file proxy.d
module conjure.patterns.proxy;

class Proxy
{
    private static char[] NAME = "BaseProxy";

    char[] getName()
    {
        return Proxy.NAME;
    }
}
//@-leo
