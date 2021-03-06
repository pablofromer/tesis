/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.Analysis;

@SuppressWarnings("nls")
public final class ADatetimefsTerm extends PTerm
{
    private TTPreDatetime _tPreDatetime_;
    private TTLpar _tLpar_;
    private TTInt _year_;
    private TTComma _tComma_;
    private TTInt _month_;
    private TTComma _c2_;
    private TTInt _day_;
    private TTComma _c3_;
    private TTInt _hour_;
    private TTComma _c4_;
    private TTInt _minute_;
    private TTComma _c5_;
    private TTDec _second_;
    private TTRpar _tRpar_;

    public ADatetimefsTerm()
    {
        // Constructor
    }

    public ADatetimefsTerm(
        @SuppressWarnings("hiding") TTPreDatetime _tPreDatetime_,
        @SuppressWarnings("hiding") TTLpar _tLpar_,
        @SuppressWarnings("hiding") TTInt _year_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") TTInt _month_,
        @SuppressWarnings("hiding") TTComma _c2_,
        @SuppressWarnings("hiding") TTInt _day_,
        @SuppressWarnings("hiding") TTComma _c3_,
        @SuppressWarnings("hiding") TTInt _hour_,
        @SuppressWarnings("hiding") TTComma _c4_,
        @SuppressWarnings("hiding") TTInt _minute_,
        @SuppressWarnings("hiding") TTComma _c5_,
        @SuppressWarnings("hiding") TTDec _second_,
        @SuppressWarnings("hiding") TTRpar _tRpar_)
    {
        // Constructor
        setTPreDatetime(_tPreDatetime_);

        setTLpar(_tLpar_);

        setYear(_year_);

        setTComma(_tComma_);

        setMonth(_month_);

        setC2(_c2_);

        setDay(_day_);

        setC3(_c3_);

        setHour(_hour_);

        setC4(_c4_);

        setMinute(_minute_);

        setC5(_c5_);

        setSecond(_second_);

        setTRpar(_tRpar_);

    }

    @Override
    public Object clone()
    {
        return new ADatetimefsTerm(
            cloneNode(this._tPreDatetime_),
            cloneNode(this._tLpar_),
            cloneNode(this._year_),
            cloneNode(this._tComma_),
            cloneNode(this._month_),
            cloneNode(this._c2_),
            cloneNode(this._day_),
            cloneNode(this._c3_),
            cloneNode(this._hour_),
            cloneNode(this._c4_),
            cloneNode(this._minute_),
            cloneNode(this._c5_),
            cloneNode(this._second_),
            cloneNode(this._tRpar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADatetimefsTerm(this);
    }

    public TTPreDatetime getTPreDatetime()
    {
        return this._tPreDatetime_;
    }

    public void setTPreDatetime(TTPreDatetime node)
    {
        if(this._tPreDatetime_ != null)
        {
            this._tPreDatetime_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tPreDatetime_ = node;
    }

    public TTLpar getTLpar()
    {
        return this._tLpar_;
    }

    public void setTLpar(TTLpar node)
    {
        if(this._tLpar_ != null)
        {
            this._tLpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLpar_ = node;
    }

    public TTInt getYear()
    {
        return this._year_;
    }

    public void setYear(TTInt node)
    {
        if(this._year_ != null)
        {
            this._year_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._year_ = node;
    }

    public TTComma getTComma()
    {
        return this._tComma_;
    }

    public void setTComma(TTComma node)
    {
        if(this._tComma_ != null)
        {
            this._tComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tComma_ = node;
    }

    public TTInt getMonth()
    {
        return this._month_;
    }

    public void setMonth(TTInt node)
    {
        if(this._month_ != null)
        {
            this._month_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._month_ = node;
    }

    public TTComma getC2()
    {
        return this._c2_;
    }

    public void setC2(TTComma node)
    {
        if(this._c2_ != null)
        {
            this._c2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c2_ = node;
    }

    public TTInt getDay()
    {
        return this._day_;
    }

    public void setDay(TTInt node)
    {
        if(this._day_ != null)
        {
            this._day_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._day_ = node;
    }

    public TTComma getC3()
    {
        return this._c3_;
    }

    public void setC3(TTComma node)
    {
        if(this._c3_ != null)
        {
            this._c3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c3_ = node;
    }

    public TTInt getHour()
    {
        return this._hour_;
    }

    public void setHour(TTInt node)
    {
        if(this._hour_ != null)
        {
            this._hour_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._hour_ = node;
    }

    public TTComma getC4()
    {
        return this._c4_;
    }

    public void setC4(TTComma node)
    {
        if(this._c4_ != null)
        {
            this._c4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c4_ = node;
    }

    public TTInt getMinute()
    {
        return this._minute_;
    }

    public void setMinute(TTInt node)
    {
        if(this._minute_ != null)
        {
            this._minute_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minute_ = node;
    }

    public TTComma getC5()
    {
        return this._c5_;
    }

    public void setC5(TTComma node)
    {
        if(this._c5_ != null)
        {
            this._c5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c5_ = node;
    }

    public TTDec getSecond()
    {
        return this._second_;
    }

    public void setSecond(TTDec node)
    {
        if(this._second_ != null)
        {
            this._second_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._second_ = node;
    }

    public TTRpar getTRpar()
    {
        return this._tRpar_;
    }

    public void setTRpar(TTRpar node)
    {
        if(this._tRpar_ != null)
        {
            this._tRpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tRpar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tPreDatetime_)
            + toString(this._tLpar_)
            + toString(this._year_)
            + toString(this._tComma_)
            + toString(this._month_)
            + toString(this._c2_)
            + toString(this._day_)
            + toString(this._c3_)
            + toString(this._hour_)
            + toString(this._c4_)
            + toString(this._minute_)
            + toString(this._c5_)
            + toString(this._second_)
            + toString(this._tRpar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tPreDatetime_ == child)
        {
            this._tPreDatetime_ = null;
            return;
        }

        if(this._tLpar_ == child)
        {
            this._tLpar_ = null;
            return;
        }

        if(this._year_ == child)
        {
            this._year_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._month_ == child)
        {
            this._month_ = null;
            return;
        }

        if(this._c2_ == child)
        {
            this._c2_ = null;
            return;
        }

        if(this._day_ == child)
        {
            this._day_ = null;
            return;
        }

        if(this._c3_ == child)
        {
            this._c3_ = null;
            return;
        }

        if(this._hour_ == child)
        {
            this._hour_ = null;
            return;
        }

        if(this._c4_ == child)
        {
            this._c4_ = null;
            return;
        }

        if(this._minute_ == child)
        {
            this._minute_ = null;
            return;
        }

        if(this._c5_ == child)
        {
            this._c5_ = null;
            return;
        }

        if(this._second_ == child)
        {
            this._second_ = null;
            return;
        }

        if(this._tRpar_ == child)
        {
            this._tRpar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tPreDatetime_ == oldChild)
        {
            setTPreDatetime((TTPreDatetime) newChild);
            return;
        }

        if(this._tLpar_ == oldChild)
        {
            setTLpar((TTLpar) newChild);
            return;
        }

        if(this._year_ == oldChild)
        {
            setYear((TTInt) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._month_ == oldChild)
        {
            setMonth((TTInt) newChild);
            return;
        }

        if(this._c2_ == oldChild)
        {
            setC2((TTComma) newChild);
            return;
        }

        if(this._day_ == oldChild)
        {
            setDay((TTInt) newChild);
            return;
        }

        if(this._c3_ == oldChild)
        {
            setC3((TTComma) newChild);
            return;
        }

        if(this._hour_ == oldChild)
        {
            setHour((TTInt) newChild);
            return;
        }

        if(this._c4_ == oldChild)
        {
            setC4((TTComma) newChild);
            return;
        }

        if(this._minute_ == oldChild)
        {
            setMinute((TTInt) newChild);
            return;
        }

        if(this._c5_ == oldChild)
        {
            setC5((TTComma) newChild);
            return;
        }

        if(this._second_ == oldChild)
        {
            setSecond((TTDec) newChild);
            return;
        }

        if(this._tRpar_ == oldChild)
        {
            setTRpar((TTRpar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
