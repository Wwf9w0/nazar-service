package com.nazar.service.model.enums;

import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MajorArcanaTarotType {

    JOKER(0, "Joker kartı serinin ilk kartıdır ve yeni başlangıçları simgeler. Joker yeni bir başlangıca doğru yola çıkar ve çantasında ihtiyacı olan her şey vardır. Yanında bulunan köpek simgesi ise onu düşmekten kurtarmaya yardım edecek, uyaracak etkenlerdir. Yeni başlangıçları ve fırsatları niteleyen karttır."),
    BUYUCU(1,"Büyücü kartı irade ve arzu kullanılarak sakinleştirilen erkek gücünü temsil eder. Özgürlüğü, yaratıcılığı, beceriyi, kendine güveni ve el becerisini gösterir. İddialı bir kariyer, aşk hayatı ya da yeni iş olarak yorulabilir."),
    AZIZE(2,"Cinsellik, gizem ve genel anlamdaki yüksek gücü gösterir. Bilgelik, öğrenme, saflık, sabırsızlık, öğretmenlik ve erdemi gösterir. Karara varmadan önce zaman tanınması gerektiğini söyler."),
    IMPARATORICE(3,"Bolluk ve bereketi simgeler. Annelik, kadınlık ve doğurganlığın göstergesidir. Romantizm, sanat ve diğer konularda yaratıcılığı sembolize eder. Gerçekleşmesini istediğiniz dilekler için sabırlı olunması gerektiğini vurgular."),
    IMPARATOR(4,"İmparator güven, servet, istikrar, baba figürü, erkek kardeş, koca, başarılı ve liderlik vasfı olan gücü temsil eder. cesur ve komuta sahibi olmayı gösterir. Aynı zamanda saldırganlık içerir. Liderliği gösterir."),
    AZIZ(5,"Aziz geleneksel değerlerin sembolizmidir. Din veya maneviyat ile ilişkilendirilir. Bu anlam açısından topluma uygunluk, sosyal onay, affetme, merhamet ve ilham alma ihtiyaçlarını gösterir."),
    ASIKLAR(6,"Aşk, romantizm, bağ, cazibe ve kusursuz uyumu simgeler. Sevgi, uyum, güven ve romantizmin başlangıcını gösterir. Yaşayacağınız şeyden kaçmadan ya da hızlı karar vermeden önce sizi düşünmeye teşvik eder."),
    ARABA(7,"Zor kazanılan başarıları gösterir. Azimli bir yolculuk, acele verilen kararlar, intikam hissini ifade eder. Aynı zamanda durgun bir durumun harekete geçeceği konusundaki motivasyonu gösterir."),
    ADALET(8,"Soğuk ve nesnel dengeyi anlatmaktadır. Karma gerçeğini yüzler önüne vurur. Doğruluk, uyum, denge, eşitlik, erdem, onur gibi tavsiyeleri simgeler. Fiziksel, sosyal, manevi ve duygusal yaşantıyı tekrar dengelemek için bir fırsatı gösterir."),
    ERMIS(9,"İç gözlem, analiz ve kendini yansıtmakla ilgilidir. Sosyalleşmekten ve eyleme geçmekten uzak durulması gerektiğini söyler. Barış ve yalnızlığı anlatır. Sabırlı olmayı, öğüt almayı ve geri çekilmeyi gösterir. Yalnız kalma beklentisine girildiği bir dönemdir."),
    KADER_CARKI(10,"Beklenmeyen olayları ve yaşanacak ilerlemeyi gösterir. Beklenmedik bir olay, bir düşüş ya da şanslı bir durum olacağını ifade eder. Her şey yolundadır ve evren sizin yanınızdadır. Fakat her şey her an değişebilmektedir."),
    GUC(11,"Enerji ve cesareti simgeler. Korkmayan bir kadın temsilidir. Ölümsüz, inatçı ve kararlı bir duruşu gösterir. Kararlı eylemlerin harekete geçtiğini söyler. İç güce önem verilmesi gerektiğini söyler."),
    ASLAN_ADAM(12,"Deneme, yanılma, başarısızlık, fedakarlık gibi anlamları gösterir. Durumları askıya alma, değiştirme, tersine çevirme, fedakarlık gösterme gibi olayları gösterir. Direnmeyi bırakmayı ve zamanı takip etmeyi söyler."),
    OLUM(13,"Büyük bir dönüşümü ve yeni başlangıçları gösterir. Yenilikler, değişimler, dönüşümler, kayıplar, iyi ya da kötü pek çok haberin öncüsüdür. Kaderi ve acıları kucaklamayı söyler."),
    DENGE(14,"Uyum, barış ve sabır gerekmesini anlatır. İyi etki ve güveni simgeler. Davranışların yumuşatılması için bir uyarı niteliği taşır. Uzlaşmayı öngörür. Çok çalışmanın göstergesidir."),
    SEYTAN(15,"Tamamen hırs, bağımlılık, ayartma ve depresyon özelliklerini taşır. Beklenmedik başarısızlık, tartışma, şiddet, felaket ya da garip deneyimler geldiğini öngörür. Kısıtlanmış değil, tutkulu ve hırslı olunması konusunda uyarıda bulunur."),
    KULE(16,"Yeni bir dinamik yaratmayı temsil eder. Eski fikirlerin çöktüğünü, ani ve büyük bir değişiklik yaşanacağını söyler. Kaos ve sıkıntının hakim gezeceği bir durumu anlatır. Geçmişin tozlu sayfalarını geride bırakmayı, para kaybını ya da kısa süreli bir mutluluğu gösterir."),
    YILDIZ(17,"Geleceği görüşü ve manevi iç görüyü temsil eder. Umut, inanç, ilham, iyimserlik, manevi aşk, denge ve zevki gösterir. Zorlukların aşıldığını ve sonrasında yaşanacaklar için hazır olduğunuzu söyler. Sakinliğin ve pozitifliğin gerekliliğini vurgular."),
    AY(18,"İlk izlenimlerinize güvenmemeniz gerektiğini ve bazı şeylerin yanlış olabileceğini söyler. Kaygı, aldatma, hayal kırıklığı, tehlike ve çifte ilişkiyi gösterir. Zihinsel ya da duygusal denemelerden geçtiğiniz söylenir. Bilinçaltınızdaki seslere kulak vermenizi söyler."),
    GUNES(19,"Pozitif enerjiyi gösterir. Memnuniyet, başarı, neşenin yaşandığını söyler. Güneşin enerjisini ve spot ışıklarını üstünüzde hissedeceğinizi söyler. Her şey oyluna girecektir. "),
    MAHKEME(20,"Kendimizi ve eylemlerimizi gösterdiğimiz, bunları değerlendirdiğimiz durumları ifade eder. Şu anda nerede ve nasıl olduğumuza bakar. Net ve nesnel bir görüş açısı vermek ister. Kendi gücünüzle değerlendirme yapmanızı ister. Mental, fiziksel ve duygusal açıdan kendi kendine büyümeyi temsil eder. Kişisel uyanış dönemini gösterir."),
    DUNYA(21,"Başarılı bir sonuca ulaşmanın temsilidir. Yolculuğun tamamlandığını söyler. Başarı, onur, sonuç, zafer ve sonsuz yaşam, mükemmeliyet, tanınma gibi temsilleri sembolize eder. Sonucu ne olursa olsun iyiye gidecek bir durumdur.");

    private final int value;
    private final String description;

    public static MajorArcanaTarotType fromValue(final int value){
        for(MajorArcanaTarotType type : MajorArcanaTarotType.values()){
            if(Objects.equal(type.getValue(), value)){
                return type;
            }
        }
        throw new RuntimeException("Unknown tarot for value : " + value);
    }
    
}
