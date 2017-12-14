package com.hgp_android.coleliga;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.hgp_android.coleliga.lugares.PlaceListActivity;
import com.hgp_android.coleliga.partidos.PartidosActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {
    /*Anuncios*/
    private AdView adView;
    private InterstitialAd interstitialAd;

    /*Gestion pagos in-app*/
    private IInAppBillingService serviceBilling;
    private ServiceConnection serviceConnection;

    private final String ID_ARTICULO = "com.hgp_android.coleliga.quitaranuncios";
    private final int INAPP_BILLING = 1;
    private final String developerPayLoad = "coleliga_team";
    private boolean showInterticial=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.aviso)
                .setPositiveButton(R.string.accion_aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
        builder.show();


        MobileAds.initialize(this, "ca-app-pub-3405615265490445~2278870838");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        CardView equipoCard = (CardView) findViewById(R.id.equiposCard);
        equipoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarEquipos(view);
            }
        });
        CardView entrenamientoCard = (CardView) findViewById(R.id.entrenamientosCard);
        entrenamientoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarEntrenamientos(view);
            }
        });
        CardView partidoCard = (CardView) findViewById(R.id.partidosCard);
        partidoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarPartidos(view);
            }
        });
        CardView resultadosCard = (CardView) findViewById(R.id.resultadosCard);
        resultadosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarResultados(view);
            }
        });
        CardView clasificacionCard = (CardView) findViewById(R.id.clasificacionCard);
        clasificacionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarClasificaciones(view);
            }
        });
        CardView lugaresCard = (CardView) findViewById(R.id.lugaresCard);
        lugaresCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarLugares(view);
            }
        });

        CardView perfilCard = (CardView) findViewById(R.id.perfilesCard);
        perfilCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarPerfil(view);
            }
        });

        CardView shareCardview = (CardView) findViewById(R.id.shareApp);
        shareCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "Coleliga: App para crear torneos. ";
                shareAppText(text +
                        "Puedes descargarla en : http://play.google.com/store/apps/details?id=" +
                        getPackageName());
            }
        });

        CardView noAdsCard = (CardView) findViewById(R.id.noAdsCard);
        noAdsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprarProducto();
            }
        });

        //Lanzamiento anuncio banner
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("9796B949D295ECF0BE1E8A93DE8C3095").build();
        adView.loadAd(adRequest);
        //Lanzamiento anuncio intersticial
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9661377198510780/3437897421");
        interstitialAd.loadAd(new AdRequest.Builder().addTestDevice("9796B949D295ECF0BE1E8A93DE8C3095").build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder()
                        .addTestDevice("9796B949D295ECF0BE1E8A93DE8C3095").build());
                Intent i = new Intent(PrincipalActivity.this, EquiposActivity.class);
                startActivity(i);
            }
        });
        /*Llamada para activar in-apps*/
        serviceConnectInAppBilling();
    }


    public void serviceConnectInAppBilling() {
        serviceConnection = new ServiceConnection() {
            @Override public void onServiceDisconnected(ComponentName name) {
                serviceBilling = null;
            }
            @Override public void onServiceConnected(ComponentName name, IBinder service) {
                serviceBilling=IInAppBillingService.Stub.asInterface(service);
                checkPurchasedInAppProducts();
            }
        };
        Intent serviceIntent = new Intent( "com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void comprarProducto() {
        if (serviceBilling != null) {
            Bundle buyIntentBundle = null;
            if (showInterticial) {
                try {
                    buyIntentBundle = serviceBilling.getBuyIntent(3, getPackageName(), ID_ARTICULO, "inapp", developerPayLoad);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
                try {
                    if (pendingIntent != null) {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), INAPP_BILLING, new Intent(), 0, 0, 0);
                    }
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            }
            else{
                Toast.makeText(this, "Ya se ha comprado la deshabilitación de anuncios", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "InApp Billing service not available", Toast.LENGTH_LONG).show();
        }
    }

    private void setAds(Boolean adsEnabled){
        if(adsEnabled) {
            AdRequest adRequest = new AdRequest.Builder() .addTestDevice("ID_DISPOSITIVO_FISICO_TEST").build();
            adView.loadAd(adRequest);
            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId("ID_BLOQUE_ANUNCIOS_INTERSTICIAL");
            interstitialAd.loadAd(new AdRequest.Builder() .addTestDevice("ID_DISPOSITIVO_FISICO_TEST").build());
            interstitialAd.setAdListener(new AdListener() {
                @Override public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder() .addTestDevice("ID_DISPOSITIVO_FISICO_TEST").build());
             }
            });
            showInterticial = true;
        }else{
            showInterticial = false;
            adView.setVisibility(View.GONE);
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case INAPP_BILLING: {
                int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
                String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
                String dataSignature = data.getStringExtra( "INAPP_DATA_SIGNATURE");
                if (resultCode == RESULT_OK) {
                    try {
                        JSONObject jo = new JSONObject(purchaseData);
                        String sku = jo.getString("productId");
                        String developerPayload = jo.getString("developerPayload");
                        String purchaseToken = jo.getString("purchaseToken");
                        if (sku.equals(ID_ARTICULO)) {
                            Toast.makeText(this,"Compra completada", Toast.LENGTH_LONG).show();
                            setAds(false);
                        }
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void checkPurchasedInAppProducts() {
        Bundle ownedItemsInApp = null;
        if (serviceBilling != null) {
            try {
                ownedItemsInApp = serviceBilling.getPurchases(3, getPackageName(), "inapp", null);
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
            int response = ownedItemsInApp.getInt("RESPONSE_CODE");
            System.out.println(response);
            if (response == 0) {
                boolean ads = false;
                ArrayList<String> ownedSkus = ownedItemsInApp .getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> purchaseDataList = ownedItemsInApp .getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> signatureList = ownedItemsInApp .getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String continuationToken = ownedItemsInApp .getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < purchaseDataList.size(); ++i) {
                    String purchaseData = purchaseDataList.get(i);
                    String signature = signatureList.get(i);
                    String sku = ownedSkus.get(i);
                    System.out.println("Inapp Purchase data: " + purchaseData);
                    System.out.println("Inapp Signature: " + signature);
                    System.out.println("Inapp Sku: " + sku);
                    if (sku.equals(ID_ARTICULO)) {
                        //Toast.makeText(this, "Inapp comprado: " + sku + "el dia " + purchaseData, Toast.LENGTH_LONG).show();
                        ads = true;
                        setAds(false);
                    }
                }
                if (!ads){
                    setAds(true);
                }
            }
        }
    }

    void lanzarEquipos(View view){
         if (interstitialAd.isLoaded() && showInterticial) {
             interstitialAd.show();
         } else {
             if (showInterticial) {
                 Toast.makeText(PrincipalActivity.this, "El Anuncio no esta disponible aun", Toast.LENGTH_LONG).show();
             }
             Intent i = new Intent(PrincipalActivity.this, EquiposActivity.class);
             startActivity(i);
         }
//Algo diferente

    }
    void lanzarEntrenamientos(View view){
        Toast.makeText(this,"Entrenamiento",Toast.LENGTH_SHORT).show();
    }
    void lanzarPartidos(View view){
        Intent i = new Intent(this,
                PartidosActivity.class);
        startActivity(i);
        //Toast.makeText(this,"Partido",Toast.LENGTH_SHORT).show();

    }
    void lanzarResultados(View view){
        Intent i = new Intent(this,
        //        ListaPartidos.class);
        Resultado.class);
        startActivity(i);
        //Toast.makeText(this,"Resultado",Toast.LENGTH_SHORT).show();
    }
    void lanzarClasificaciones(View view){
        Intent i = new Intent(this,
                ListasTorneos.class);
        startActivity(i);
    }
    void lanzarLugares(View view){
        //Toast.makeText(this,"Lugares",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                PlaceListActivity.class);
        startActivity(i);
    }
    void lanzarPerfil(View view){
        //Toast.makeText(this,"Perfil",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                RegistroFull.class);
        startActivity(i);
    }

    void shareAppText(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(i, "Selecciona aplicación"));
    }

}
