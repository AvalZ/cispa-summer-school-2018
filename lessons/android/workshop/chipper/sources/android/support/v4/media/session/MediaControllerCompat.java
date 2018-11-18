package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.app.e;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        private final List<a> a;
        private b b;
        private HashMap<a, a> c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.b = android.support.v4.media.session.b.a.a(e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        private static class a extends c {
            a(a aVar) {
                super(aVar);
            }

            public void a() {
                throw new AssertionError();
            }

            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void a(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void a(List<QueueItem> list) {
                throw new AssertionError();
            }
        }

        private void a() {
            if (this.b != null) {
                synchronized (this.a) {
                    for (a aVar : this.a) {
                        a aVar2 = new a(aVar);
                        this.c.put(aVar, aVar2);
                        aVar.b = true;
                        try {
                            this.b.a(aVar2);
                            aVar.a();
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.a.clear();
                }
            }
        }
    }

    public static abstract class a implements DeathRecipient {
        a a;
        boolean b;
        private final Object c;

        private class a extends Handler {
            boolean a;
            final /* synthetic */ a b;

            public void handleMessage(Message message) {
                if (this.a) {
                    switch (message.what) {
                        case 1:
                            this.b.a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.b.a((b) message.obj);
                            return;
                        case 5:
                            this.b.a((List) message.obj);
                            return;
                        case 6:
                            this.b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.b.a((Bundle) message.obj);
                            return;
                        case 8:
                            this.b.b();
                            return;
                        case 9:
                            this.b.a(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            this.b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.b.b(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.b.a();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class b implements android.support.v4.media.session.c.a {
            private final WeakReference<a> a;

            b(a aVar) {
                this.a = new WeakReference(aVar);
            }

            public void a() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            public void a(Object obj) {
                a aVar = (a) this.a.get();
                if (aVar != null && !aVar.b) {
                    aVar.a(PlaybackStateCompat.a(obj));
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null && (!aVar.b || VERSION.SDK_INT >= 23)) {
                    aVar.a(str, bundle);
                }
            }

            public void a(List<?> list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(QueueItem.a((List) list));
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }
        }

        private static class c extends android.support.v4.media.session.a.a {
            private final WeakReference<a> a;

            c(a aVar) {
                this.a = new WeakReference(aVar);
            }

            public void a() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            public void a(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    Object obj;
                    if (parcelableVolumeInfo != null) {
                        b bVar = new b(parcelableVolumeInfo.a, parcelableVolumeInfo.b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e);
                    } else {
                        obj = null;
                    }
                    aVar.a(4, obj, null);
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a(List<QueueItem> list) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void a(boolean z) {
            }

            public void b() {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }

            public void b(int i) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void b(boolean z) {
                a aVar = (a) this.a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001b in {2, 4, 5} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
            */
        public a() {
            /*
            r2 = this;
            r2.<init>();
            r0 = android.os.Build.VERSION.SDK_INT;
            r1 = 21;
            if (r0 < r1) goto L_0x0015;
        L_0x0009:
            r0 = new android.support.v4.media.session.MediaControllerCompat$a$b;
            r0.<init>(r2);
            r0 = android.support.v4.media.session.c.a(r0);
        L_0x0012:
            r2.c = r0;
            return;
        L_0x0015:
            r0 = new android.support.v4.media.session.MediaControllerCompat$a$c;
            r0.<init>(r2);
            goto L_0x0012;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.a.<init>():void");
        }

        public void a() {
        }

        public void a(int i) {
        }

        void a(int i, Object obj, Bundle bundle) {
            if (this.a != null) {
                Message obtainMessage = this.a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(int i) {
        }
    }

    public static final class b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }
}
