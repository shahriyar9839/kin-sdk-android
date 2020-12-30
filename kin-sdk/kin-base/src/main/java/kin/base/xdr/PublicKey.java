// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package kin.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union PublicKey switch (PublicKeyType type)
//  {
//  case PUBLIC_KEY_TYPE_ED25519:
//      uint256 ed25519;
//  };

//  ===========================================================================
public class PublicKey {
    public PublicKey() {
    }

    PublicKeyType type;

    public PublicKeyType getDiscriminant() {
        return this.type;
    }

    public void setDiscriminant(PublicKeyType value) {
        this.type = value;
    }

    private Uint256 ed25519;

    public Uint256 getEd25519() {
        return this.ed25519;
    }

    public void setEd25519(Uint256 value) {
        this.ed25519 = value;
    }

    public static void encode(XdrDataOutputStream stream, PublicKey encodedPublicKey) throws IOException {
        stream.writeInt(encodedPublicKey.getDiscriminant().getValue());
        switch (encodedPublicKey.getDiscriminant()) {
            case PUBLIC_KEY_TYPE_ED25519:
                Uint256.encode(stream, encodedPublicKey.ed25519);
                break;
        }
    }

    public static PublicKey decode(XdrDataInputStream stream) throws IOException {
        PublicKey decodedPublicKey = new PublicKey();
        PublicKeyType discriminant = PublicKeyType.decode(stream);
        decodedPublicKey.setDiscriminant(discriminant);
        switch (decodedPublicKey.getDiscriminant()) {
            case PUBLIC_KEY_TYPE_ED25519:
                decodedPublicKey.ed25519 = Uint256.decode(stream);
                break;
        }
        return decodedPublicKey;
    }
}
