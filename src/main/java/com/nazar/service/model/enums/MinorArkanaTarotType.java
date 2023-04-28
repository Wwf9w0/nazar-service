package com.nazar.service.model.enums;

import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum MinorArkanaTarotType {

    DEGNEK_KRALI(0, "İlham alma zamanının geldiğini söyler. Risk almanın, yol göstermenin ve bir sıçrama döneminin geldiğine işaret eder. Heyecan verici, cesur ve dramatik adımlar atılabilir. Eyleme geçiren bir karttır."),
    DEGNEK_KRALICESI(1,"Çekici, içten, neşeli, enerjik ve kendine güvenen biri olmayı gösterir. Durumları olumlu yönden ele alır. Başarıya olan inancı sonsuz, fakat kibri yok denecek kadar azdır. Gereken şeyin kendine inanmak olduğunu ve enerji dolu olmayı ister."),
    DEGNEK_SOVALYESI(2,"Yüzeysel büyüleyicilik, kendini beğenmişlik, aptallığın verdiği cesurluk, huzursuzluk veren bir maceracılık durumunu gösterir. Yeni adımlar atmaya asla korkmuyor gibi gözüken fakat tüm cesaretini tutkusundan alan birini sembolize eder. Enerjinin yararlı olup olmadığı konusunda ise düşünülmelidir. Adımın sonunda gelecek karşılığın dengeyi sağlayıp sağlamadığı incelenmelidir."),
    DEGNEK_PRENSI(3,"Hevesli, kendine güvenen ve yaratıcı birini gösterir. Yeni bir açık alan imkanı bulunacağının ve yeteneklerinizi beslemenize imkan tanınacağının göstergesidir. İlham alacağı, şans bulacağı, kendini ifade edeceği yeni bir yaklaşım bulmak üzeredir. "),
    DEGNEK_ONLUSU(4,"Aşırı uzatma, fazla çalışma, baskı, yük ve mücadele etme anlamları taşımaktadır. Kendinizi fazla zorladığınızı ve üstünüzdeki yüklerden kurtulmanız gerektiğini söyler. Bazı sorumlulukları paylaşmanız gerekmektedir. "),
    DEGNEK_DOKUZLUSU(5,"Azim, dayanıklılık, savunmasızlık, direnç gibi anlamlara gelir. Fiziksel ya da zihinsel olarak gelebilecek bir zararı gösterebilir. "),
    DEGNEK_SEKIZLISI(6,"İletişim, seyahat, hız gibi temsilleri vardır. Hareketlerinizi hızla yaptığınız sürece sizin açınızdan her şey doğru gitmeye devam edecektir. Bazı iyi haberler de size ulaşmak üzere yola çıkmıştır. Haberlerin alt metinlerde gizli olması sebebiyle uyanık olunması gereklidir. Harekete geçirdiğiniz konularda açık olmaktan ve paylaşmaktan çekinmeyin."),
    DEGNEK_YEDILISI(7,"Savunma, meydan okuma, saldırganlık, mahkum olma ve cesaret etme gibi anlamlara gelir. Bazı çatılmalar anlam taşısa da bazıları yalnızca bela olur. Uğruna savaşacağınız amaca hizmet edip etmeyeceği konusunda bir iç münakaşa yaşamanız gerekmektedir. Enerji akışını yönlendirmede son derece önemli bir karttır. "),
    DEGNEK_ALTILISI(8,"Zafer, beğeni ve gururu anlatır. Aklınızdaki hedefin ulaşılabilir konumda olduğunu söyler. Bir süredir beklediğiniz tanınmışlık hissini kazanmanızın zamanı gelmiştir. Hak etmiş olduğunuz tüm beğeniyi, onuru ve ödülleri almanızı ifade eder."),
    DEGNEK_BESLISI(9,"Zorluklar, anlaşmazlıklar, rekabet, sürtüşmeler, çekişmeler ve güçlükleri gösterir. Hiçbir şeyin doğru akışta ilerlemediğini ve tersleştiğini hissettirir. İstekleriniz doğrultusunda hareketlerinizin daha fazla sabırlı ve azimli olması gerektiğini söyler. "),
    DEGNEK_DORTLUSU(10,"Kutlama, özgürlük ve heyecanı gösterir. Refaha erildiğinin ve heyecan veren ortaklıkların başladığını söyler. Beklenmedik bir sürprizi temsil edebilir. Kişisel gelişimin yeni bir evresini, duygusal, fiziksel ya da zihinsel bağların birbirinden kopmasını da ifade edebilir. "),
    DEGNEK_UCLUSU(11,"Vizyonu temsil etmektedir. Vizyon ve perspektif kazanımları demektir. Fakat geri adım atılmalı ve tekrar düşünülmelidir. İlerleme eksikliğini ve geride tutulmaya itilen duyguları temsil eder. Görüş eksikliğinin getirdiği koşullardan doğan mutsuzluğu simgeler. "),
    DEGNEK_IKILISI(12,"Gücü, cesareti ve özgünlüğü gösterir. Bireysel cesaret ve büyüklüktür. Kişiye harika olma cesaretini sunar. Gücün kaynağının ilahi olduğunu ve kanal olduğunu yeniden hatırlamanız gerekir. Güç sarhoşluğunun, kötü niyet temeline ilerlememesi gerektiği konusunda uyarır. Fakat güçlerinizi doğru bir şekilde kullanmanız gerektiğinin zamanının geldiğini söyler. "),
    DEGNEK_ASI(13,"Coşku, cesaret ve yaratıcı güçtür. Kendine güvenen bir enerjiye sahiptir. İstekleriniz için risk almanız gerektiğini söyler. Heyecan duyduğunuz yola ilk adımı atmanızın ardından her şey beklenmedik bir heyecanla gerçekleşecektir.");

    private final int value;
    private final String description;

    public static MinorArkanaTarotType fromValue(final int value){
        for(MinorArkanaTarotType type : MinorArkanaTarotType.values()){
            if(Objects.equal(type.getValue(), value)){
                return type;
            }
        }
        throw new RuntimeException("Unknown tarot for value : " + value);
    }

    
}
