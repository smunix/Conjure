//@+leo-ver=5-thin
//@+node:roobie.20110513155345.1312: * @file facade.d
module patterns.facade;

import interfaces.ifacade;

/**
    The facade is the singleton, which acts as a representative
    for the core actors. All communication should go through
    this.

    Implements all public methods/functions of the core
    actors.
*/
class Facade : IFacade
{
    private static IFacade instance;

    this()
    {
        Facade.instance = this;
    }

    /**
        Singleton factory for Facade. 
     */
    static IFacade getInstance()
    {
        if (Facade.instance is null)
        {
            return new Facade();
        }
        return Facade.instance;
    }

    unittest
    {
        Facade facade0 = cast(Facade)Facade.getInstance();
        assert(facade0 is facade0);

        Facade facade1 = cast(Facade)Facade.getInstance();
        assert(facade0 is facade1);
    }

}
//@-leo
