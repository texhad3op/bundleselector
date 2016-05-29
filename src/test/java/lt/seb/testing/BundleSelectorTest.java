package lt.seb.testing;

import org.junit.Before;
import org.junit.Test;

import lt.seb.testing.resolver.types.Bundle;
import lt.seb.testing.services.AccountResolverService;
import lt.seb.testing.services.BundleResolverService;
import lt.seb.testing.services.BundleSelectorServiceImpl;
import lt.seb.testing.services.CardResolverService;


public class BundleSelectorTest {

    BundleSelectorServiceImpl bundleSelectorServiceImpl;



    @Before
    public void setUp() throws Exception {
        bundleSelectorServiceImpl = new BundleSelectorServiceImpl();
        AccountResolverService accountResolverService = new AccountResolverService();
        accountResolverService.init();
        bundleSelectorServiceImpl.setAccountResolverService(accountResolverService);
        
        CardResolverService cardResolverService = new CardResolverService();
        cardResolverService.init();
        bundleSelectorServiceImpl.setCardResolverService(cardResolverService);

        BundleResolverService bundleResolverService = new BundleResolverService();
        bundleResolverService.init();
        bundleSelectorServiceImpl.setBundleResolverService(bundleResolverService);
        
    }

    @Test
    public void JuniorSaverTest() {
        Answer answer = bundleSelectorServiceImpl.resolveBundle(15, true, 32);
        org.junit.Assert.assertEquals(answer.getBundle(), Bundle.JUNIOR_SAVER);
    }

    @Test
    public void GoldTest() {
        Answer answer = bundleSelectorServiceImpl.resolveBundle(19, true, 50000);
        org.junit.Assert.assertEquals(answer.getBundle(), Bundle.GOLD);
    }
    
    @Test
    public void AssimeGoldButClassicPlusInRealTest() {
        Answer answer = bundleSelectorServiceImpl.resolveBundle(19, true, 17000);
        org.junit.Assert.assertNotEquals(answer.getBundle(), Bundle.GOLD);
    }    
    
}


