package com.example.lib_tinker;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class SampleApplication extends TinkerApplication {
    protected SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.example.lib_tinker.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
