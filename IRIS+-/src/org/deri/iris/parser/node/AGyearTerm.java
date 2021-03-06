/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.Analysis;

@SuppressWarnings("nls")
public final class AGyearTerm extends PTerm
{
    private TTPreGyear _tPreGyear_;
    private TTLpar _tLpar_;
    private TTInt _tInt_;
    private TTRpar _tRpar_;

    public AGyearTerm()
    {
        // Constructor
    }

    public AGyearTerm(
        @SuppressWarnings("hiding") TTPreGyear _tPreGyear_,
        @SuppressWarnings("hiding") TTLpar _tLpar_,
        @SuppressWarnings("hiding") TTInt _tInt_,
        @SuppressWarnings("hiding") TTRpar _tRpar_)
    {
        // Constructor
        setTPreGyear(_tPreGyear_);

        setTLpar(_tLpar_);

        setTInt(_tInt_);

        setTRpar(_tRpar_);

    }

    @Override
    public Object clone()
    {
        return new AGyearTerm(
            cloneNode(this._tPreGyear_),
            cloneNode(this._tLpar_),
            cloneNode(this._tInt_),
            cloneNode(this._tRpar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGyearTerm(this);
    }

    public TTPreGyear getTPreGyear()
    {
        return this._tPreGyear_;
    }

    public void setTPreGyear(TTPreGyear node)
    {
        if(this._tPreGyear_ != null)
        {
            this._tPreGyear_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tPreGyear_ = node;
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

    public TTInt getTInt()
    {
        return this._tInt_;
    }

    public void setTInt(TTInt node)
    {
        if(this._tInt_ != null)
        {
            this._tInt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tInt_ = node;
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
            + toString(this._tPreGyear_)
            + toString(this._tLpar_)
            + toString(this._tInt_)
            + toString(this._tRpar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tPreGyear_ == child)
        {
            this._tPreGyear_ = null;
            return;
        }

        if(this._tLpar_ == child)
        {
            this._tLpar_ = null;
            return;
        }

        if(this._tInt_ == child)
        {
            this._tInt_ = null;
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
        if(this._tPreGyear_ == oldChild)
        {
            setTPreGyear((TTPreGyear) newChild);
            return;
        }

        if(this._tLpar_ == oldChild)
        {
            setTLpar((TTLpar) newChild);
            return;
        }

        if(this._tInt_ == oldChild)
        {
            setTInt((TTInt) newChild);
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
