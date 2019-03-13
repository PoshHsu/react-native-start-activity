using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Start.Activity.RNStartActivity
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNStartActivityModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNStartActivityModule"/>.
        /// </summary>
        internal RNStartActivityModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNStartActivity";
            }
        }
    }
}
