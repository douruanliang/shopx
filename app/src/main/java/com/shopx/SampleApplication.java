package com.shopx;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class SampleApplication extends TinkerApplication {
    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.example.lib_tinker.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
